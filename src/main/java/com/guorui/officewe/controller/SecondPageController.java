package com.guorui.officewe.controller;

import com.guorui.officewe.DTO.OrderDTO;
import com.guorui.officewe.DTO.UserCollectionDTO;
import com.guorui.officewe.dataobject.*;
import com.guorui.officewe.enums.ResultEnum;
import com.guorui.officewe.exception.SellException;
import com.guorui.officewe.service.*;
import com.guorui.officewe.vo.collection.*;
import com.guorui.officewe.vo.myInfo.MyInfo2;
import com.guorui.officewe.vo.myInfo.MyInfoResultVO;
import com.guorui.officewe.vo.myInfo.MyInfoVO;
import com.guorui.officewe.vo.myInfo.UpdateInfoVO;
import com.guorui.officewe.vo.configure.UpdateConfigVO;
import com.guorui.officewe.vo.configure.ConfigVO;
import com.guorui.officewe.vo.order.OrderDataVO;
import com.guorui.officewe.vo.order.OrderVO;
import com.guorui.officewe.vo.shopInfo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hazsly
 * @date 2018/3/21 14:48
 */
@RestController
@RequestMapping("/info")
public class SecondPageController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserCollectionService userCollectionService;

    @Autowired
    private ShopClassService shopClassService;

    @Autowired
    private ShopService shopService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserPayService userPayService;

    @Autowired
    private OwShopIndustryService owShopIndustryService;

    @Autowired
    private OwShopDetailsService owShopDetailsService;

    @Autowired
    private OwShopPromptService owShopPromptService;


    /** 个人信息详情页*/
    @PostMapping("/myInfo")
    public MyInfoResultVO myInfo(Integer id){
        MyInfoVO myInfoVO = new MyInfoVO();
        MyInfo2 myInfo2 = new MyInfo2();
        OwUser owUser = userService.findById(id);
        myInfoVO.setPortrait(owUser.getPortrait());
        myInfoVO.setNickname(owUser.getNickname());
        myInfoVO.setSex(owUser.getSex());
        myInfoVO.setId(owUser.getId());
        myInfo2.setMyInfoVO(myInfoVO);
        return MyInfoResultVO.success(myInfo2);
    }


    /** 个人信息更新接口*/
    @PostMapping("/updateInfo")
    public UpdateInfoVO updateInfo(@RequestParam("portrait") String portrait,@RequestParam("nickname") String nickname,
                                   @RequestParam("sex")Integer sex, @RequestParam("id")Integer id){
        OwUser owUser = userService.findById(id);
        owUser.setPortrait(portrait);
        owUser.setNickname(nickname);
        owUser.setSex(sex);
        UpdateInfoVO updateInfoVO = new UpdateInfoVO();
        if (owUser.getNickname()!=null&&owUser.getPortrait()!=null&&owUser.getSex()!=null) {
            updateInfoVO.setCode(0);
            updateInfoVO.setMsg("成功");
            userService.save(owUser);
        }else {
            updateInfoVO.setCode(1);
            updateInfoVO.setMsg("失败");
        }
        return updateInfoVO;
    }


    /** 查看个人设置页面，修改密码*/
    @PostMapping("/configure")
    public ConfigVO updateConfig(@RequestParam("id") Integer id){
        OwUser owUser = userService.findById(id);
        ConfigVO configVO = new ConfigVO();
        if (owUser.getUsername()!=null){
            configVO.setCode(0);
            configVO.setMsg("成功");
            configVO.setUsername(owUser.getUsername());
        }else {
            configVO.setCode(1);
            configVO.setMsg("失败");
            configVO.setUsername("未绑定");
        }
        return configVO;
    }


    /** 个人设置页面修改密码接口*/
    @PostMapping("/updateConfigure")
    public UpdateConfigVO config(@RequestParam("id") Integer id, @RequestParam("username") String username){
        UpdateConfigVO updateConfigVO = new UpdateConfigVO();
        OwUser owUser = userService.findById(id);
        if (username!=null) {
            owUser.setUsername(username);
            userService.save(owUser);
            updateConfigVO.setCode(0);
            updateConfigVO.setMsg("成功");
        }else {
            updateConfigVO.setCode(1);
            updateConfigVO.setMsg("失败");
        }
        return updateConfigVO;
    }


    /** 查看个人收藏页面*/
    @PostMapping("/checkCollection")
    public  MyCollectionVO  myCollection(@RequestParam("userId")Integer userId,
                                         @RequestParam(value = "page",defaultValue = "0") Integer page,
                                         @RequestParam(value = "size",defaultValue = "10") Integer size){
        Collection collection = new Collection();
        PageRequest request = new PageRequest(page,size);
        Page<UserCollectionDTO> userCollectionDTOPage = userCollectionService.myCollection(userId,request);
        for (UserCollectionDTO userCollectionDTO: userCollectionDTOPage){
            OwShop owShop = shopService.findById(userCollectionDTO.getShopId());
            userCollectionDTO.setName(shopClassService.findOne(owShop.getCId()).getName());
            userCollectionDTO.setShopImg(owShop.getShopImg());
            userCollectionDTO.setShopArea(owShop.getShopArea());
            userCollectionDTO.setShopSize(owShop.getShopSizeEnd());
            userCollectionDTO.setShopSeat(owShop.getShopSeat());
            userCollectionDTO.setPrice(owShop.getPrice());
        }
        collection.setUserCollectionDTOList(userCollectionDTOPage.getContent());
        return MyCollectionVO.success(collection);
    }


    /** 新增收藏接口*/
    @PostMapping("/collection")
    public UpdateCollection create(@RequestParam("userId")Integer userId,
                                   @RequestParam("shopId")Integer shopId){
        List<OwUserCollection> owUserCollectionList = userCollectionService.findByUserId(userId);
        for (OwUserCollection owUserCollection: owUserCollectionList){
            if (owUserCollection.getUserId().equals(userId)&&owUserCollection.getShopId().equals(shopId)){
                throw new SellException(ResultEnum.COLLECTION_IS_EXIST);
            }
        }
        OwUserCollection owUserCollection = userCollectionService.create(userId, shopId);
        UpdateCollection updateCollection = new UpdateCollection();
        updateCollection.setCode(0);
        updateCollection.setMsg("添加成功！");
        return updateCollection;
    }


    /** 取消收藏接口*/
    @PostMapping("/noCollection")
    @Transactional(rollbackFor = Exception.class)
    public DeleteCollection deleteCollection(@RequestParam("userId")Integer userId,
                                             @RequestParam("shopId")Integer shopId){
        int a =  userCollectionService.deleteByUserIdAndShopId(userId,shopId);
        DeleteCollection deleteCollection = new DeleteCollection();
        if (userCollectionService.findByUserIdAndShopId(userId,shopId)==null){
            deleteCollection.setCode(0);
            deleteCollection.setMsg("收藏删除成功！生效条数："+ a +"条");
        }
        return deleteCollection;
    }


    /** 查看个人订单页面（全部，代付款两个子页面）*/
    @PostMapping("/checkOrder")
    public OrderVO myOrder(@RequestParam("userId") Integer userId,
                           @RequestParam("status") Integer status,
                           @RequestParam(value = "page",defaultValue = "0") Integer page,
                           @RequestParam(value = "size",defaultValue = "10") Integer size){
        OrderDataVO orderDataVO = new OrderDataVO();
        PageRequest request = new PageRequest(page, size);
        if (status==10) {
            Page<OrderDTO> orderDTOPage = orderService.allOrderList(userId,request);
           for (OrderDTO orderDTO: orderDTOPage){
                List<OwOrder> owOrderList = orderService.findUserAll(userId);
                for (OwOrder owOrder: owOrderList) {
                    OwShop owShop = shopService.findById(owOrder.getShopId());
                    orderDTO.setShopImg(owShop.getShopImg());
                    String orderInfo = owOrder.getShopInfo();
                    String[] orderInfoSplit = orderInfo.split("/");
                    orderDTO.setShopTime(orderInfoSplit[0]);
                    orderDTO.setShopUntilTime(orderInfoSplit[1]);
                    orderDTO.setShopPersonNumber(orderInfoSplit[2]);
                    OwUserPay owUserPay = userPayService.findOne(owOrder.getShopNumber());
                    orderDTO.setPrice(owUserPay.getAmount());
                }
            }
            orderDataVO.setOrderDTOList(orderDTOPage.getContent());
        }else if (status==0){
            Page<OrderDTO> orderDTOPage = orderService.noPayOrderList(userId,0,request);
            for (OrderDTO orderDTO: orderDTOPage){
                List<OwOrder> owOrderList = orderService.findUserAll(userId);
                for (OwOrder owOrder: owOrderList) {
                    OwShop owShop = shopService.findById(owOrder.getShopId());
                    orderDTO.setShopImg(owShop.getShopImg());
                    String orderInfo = owOrder.getShopInfo();
                    String[] orderInfoSplit = orderInfo.split("/");
                    orderDTO.setShopTime(orderInfoSplit[0]);
                    orderDTO.setShopUntilTime(orderInfoSplit[1]);
                    orderDTO.setShopPersonNumber(orderInfoSplit[2]);
                    OwUserPay owUserPay = userPayService.findOne(owOrder.getShopNumber());
                    orderDTO.setPrice(owUserPay.getAmount());
                }
            }
            orderDataVO.setOrderDTOList(orderDTOPage.getContent());
        }
        return OrderVO.success(orderDataVO);
    }


    /** 点击商品，根据商品id查看产品详情页面*/
    @PostMapping("/info")
    public ShopInfoVO shopInfo(@RequestParam("id")Integer id){
        OwShop owShop = shopService.findById(id);

        Shop2 shop2 = new Shop2();
        Shop shop = new Shop();
        ShopTop shopTop = new ShopTop();
        List<ShopSupport> shopSupportList = new ArrayList<>();
        List<ShopDetail>  shopDetailList = new ArrayList<>();

        /** 详情页Top.*/
        shopTop.setShopId(owShop.getId());
        shopTop.setShopImg(owShop.getShopImg());
        shopTop.setShopName(owShop.getShopName());
        shopTop.setPrice(owShop.getPrice());
        shopTop.setShopSizeEnd(owShop.getShopSizeEnd());
        shopTop.setShopSeat(owShop.getShopSeat());
        shopTop.setUseTime(owShop.getUseTime());
        shopTop.setAddress(owShop.getAddress());


        /** 配套设施.*/
        List<OwShopIndustry> owShopIndustryList = owShopIndustryService.findAll(owShop.getId());
        for (OwShopIndustry owShopIndustry: owShopIndustryList) {
            ShopSupport shopSupport = new ShopSupport();
            shopSupport.setName(owShopIndustryService.findOne(owShopIndustry.getId()).getName());
            shopSupport.setIcon(owShopIndustryService.findOne(owShopIndustry.getId()).getIcon());
            shopSupportList.add(shopSupport);
        }

        /** 详细介绍.*/
        List<OwShopDetails> owShopDetailsList = owShopDetailsService.findAll(owShop.getId());
        for (OwShopDetails owShopDetails: owShopDetailsList){
            ShopDetail shopDetail = new ShopDetail();
            shopDetail.setTitle(owShopDetailsService.findOne(owShopDetails.getDetailsId()).getTitle());
            shopDetail.setValue(owShopDetailsService.findOne(owShopDetails.getDetailsId()).getValue());
            shopDetailList.add(shopDetail);
        }

        /** 温馨提示.*/
        OwShopPrompt owShopPrompt = owShopPromptService.findByShopId(owShop.getId());
        ShopPrompt shopPrompt = new ShopPrompt();
        shopPrompt.setValue(owShopPrompt.getValue());
        shop.setShopTop(shopTop);
        shop.setShopSupport(shopSupportList);
        shop.setShopPrompt(shopPrompt);
        shop.setShopDetail(shopDetailList);
        shop2.setShop(shop);
        return ShopInfoVO.success(shop2);
    }


}
