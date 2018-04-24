package com.guorui.officewe.controller;

import com.guorui.officewe.DTO.FindSeatDTO;
import com.guorui.officewe.enums.ShopStatusEnum;
import com.guorui.officewe.vo.index.*;
import com.guorui.officewe.vo.my.My;
import com.guorui.officewe.vo.my.My2;
import com.guorui.officewe.vo.my.MyVO;
import com.guorui.officewe.dataobject.*;
import com.guorui.officewe.service.*;
import com.guorui.officewe.vo.findSeat.FindSeatVO;
import com.guorui.officewe.vo.findSeat.ShopDataVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**APP首页类目信息
 * @author Hazsly
 * @date 2018/3/9 17:10
 */
@RestController
@RequestMapping("/index")
@Slf4j
public class IndexCategoryController {

    @Autowired
    private ShopService shopService;

    @Autowired
    private BannerService bannerService;

    @Autowired
    private RecommendService recommendService;

    @Autowired
    private UserAccountService userAccountService;

    @Autowired
    private UserService userService;

    @Autowired
    private ShopClassService shopClassService;


    /** 首页展示数据（轮播图，热门推荐：六大分类各两个）*/
    @PostMapping("/list")
    public IndexVO list(){
        IndexVO indexVO = new IndexVO();
        DataVO dataVO = new DataVO();
        List<BannerVO> bannerVOList = new ArrayList<>();
        //1.查询所有轮播图
        List<OwBanner> owBannerList = bannerService.findAll();
        //2.查询所有轮播图（一次性查询）
        List<Integer> bannerTypeList = owBannerList.stream().map(a -> a.getBannerType()).collect(Collectors.toList());
        List<OwBanner> bannerList = bannerService.findByBannerTypeIn(bannerTypeList);
        for (OwBanner owBanner: bannerList){
            BannerVO bannerVO = new BannerVO();
            bannerVO.setShopId(owBanner.getShopId());
            bannerVO.setBannerType(owBanner.getBannerType());
            bannerVO.setBanner(owBanner.getBanner());
            bannerVO.setBannerIcon(owBanner.getBannerIcon());
            bannerVOList.add(bannerVO);
        }
        dataVO.setBannerVO(bannerVOList);

        RecommendVO recommendVO = new RecommendVO();
        List<OfficesVO> officesVOList = new ArrayList<>();
        List<OfficeVO> officeVOList = new ArrayList<>();
        List<SeatVO> seatVOList = new ArrayList<>();
        List<MeetingVO> meetingVOList = new ArrayList<>();
        List<TrainVO> trainVOList = new ArrayList<>();
        List<BusinessVO> businessVOList = new ArrayList<>();

        /** 封装展示热门推荐数据*/
        //
        List<OwShop> owShopList = shopService.recommend(ShopStatusEnum.UP.getCode(),0,0);
        for (OwShop owShop: owShopList){
            OfficesVO officesVO = new OfficesVO();
             officesVO.setShopImg(owShop.getShopImg());
             officesVO.setShopName(owShop.getShopName());
             officesVO.setName(shopClassService.findOne(0).getName());
             officesVO.setShopPeople(owShop.getShopPeople());
             officesVO.setShopSizeEnd(owShop.getShopSizeEnd());
             officesVO.setDeposit(owShop.getDeposit());
             officesVOList.add(officesVO);
         }
         recommendVO.setOfficesVOList(officesVOList);

        List<OwShop> owShopList1 = shopService.recommend(ShopStatusEnum.UP.getCode(),0,1);
        for (OwShop owShop: owShopList1){
            OfficeVO officeVO = new OfficeVO();
            officeVO.setShopImg(owShop.getShopImg());
            officeVO.setShopName(owShop.getShopName());
            officeVO.setName(shopClassService.findOne(1).getName());
            officeVO.setShopPeople(owShop.getShopPeople());
            officeVO.setShopSizeEnd(owShop.getShopSizeEnd());
            officeVO.setDeposit(owShop.getDeposit());
            officeVOList.add(officeVO);
        }
        recommendVO.setOfficeVOList(officeVOList);

        List<OwShop> owShopList2 = shopService.recommend(ShopStatusEnum.UP.getCode(),0,2);
        for (OwShop owShop: owShopList2){
            SeatVO seatVO = new SeatVO();
            seatVO.setShopImg(owShop.getShopImg());
            seatVO.setShopName(owShop.getShopName());
            seatVO.setName(shopClassService.findOne(2).getName());
            seatVO.setShopPeople(owShop.getShopPeople());
            seatVO.setShopSizeEnd(owShop.getShopSizeEnd());
            seatVO.setDeposit(owShop.getDeposit());
            seatVOList.add(seatVO);
        }
        recommendVO.setSeatVOList(seatVOList);

        List<OwShop> owShopList3 = shopService.recommend(ShopStatusEnum.UP.getCode(),0,3);
        for (OwShop owShop: owShopList3){
            MeetingVO meetingVO = new MeetingVO();
            meetingVO.setShopImg(owShop.getShopImg());
            meetingVO.setShopName(owShop.getShopName());
            meetingVO.setName(shopClassService.findOne(3).getName());
            meetingVO.setShopPeople(owShop.getShopPeople());
            meetingVO.setShopSizeEnd(owShop.getShopSizeEnd());
            meetingVO.setDeposit(owShop.getDeposit());
            meetingVOList.add(meetingVO);
        }
        recommendVO.setMeetingVOList(meetingVOList);

        List<OwShop> owShopList4 = shopService.recommend(ShopStatusEnum.UP.getCode(),0,4);
        for (OwShop owShop: owShopList4){
            TrainVO trainVO = new TrainVO();
            trainVO.setShopImg(owShop.getShopImg());
            trainVO.setShopName(owShop.getShopName());
            trainVO.setName(shopClassService.findOne(4).getName());
            trainVO.setShopPeople(owShop.getShopPeople());
            trainVO.setShopSizeEnd(owShop.getShopSizeEnd());
            trainVO.setDeposit(owShop.getDeposit());
            trainVOList.add(trainVO);
        }
        recommendVO.setTrainVOList(trainVOList);

        List<OwShop> owShopList5 = shopService.recommend(ShopStatusEnum.UP.getCode(),0,5);
        for (OwShop owShop: owShopList5){
            BusinessVO businessVO = new BusinessVO();
            businessVO.setShopImg(owShop.getShopImg());
            businessVO.setShopName(owShop.getShopName());
            businessVO.setName(shopClassService.findOne(5).getName());
            businessVO.setShopPeople(owShop.getShopPeople());
            businessVO.setShopSizeEnd(owShop.getShopSizeEnd());
            businessVO.setDeposit(owShop.getDeposit());
            businessVOList.add(businessVO);
        }
        recommendVO.setBusinessVOList(businessVOList);

        dataVO.setRecommendVO(recommendVO);
        indexVO.setData(dataVO);
        indexVO.setMsg("成功");
        indexVO.setCode(0);
        return indexVO;
    }

    /** 热门推荐展示：六大分类各两个*/
    @PostMapping("/recommend")
    public IndexVO recommend(){
        IndexVO indexVO = new IndexVO();
        DataVO dataVO = new DataVO();
        RecommendVO recommendVO = new RecommendVO();
        List<OfficesVO> officesVOList = new ArrayList<>();
        List<OfficeVO> officeVOList = new ArrayList<>();
        List<SeatVO> seatVOList = new ArrayList<>();
        List<MeetingVO> meetingVOList = new ArrayList<>();
        List<TrainVO> trainVOList = new ArrayList<>();
        List<BusinessVO> businessVOList = new ArrayList<>();
        List<OwShop> owShopList = shopService.recommend(ShopStatusEnum.UP.getCode(),0,0);
        for (OwShop owShop: owShopList){
            OfficesVO officesVO = new OfficesVO();
            officesVO.setShopImg(owShop.getShopImg());
            officesVO.setShopName(owShop.getShopName());
            officesVO.setName(shopClassService.findOne(0).getName());
            officesVO.setShopPeople(owShop.getShopPeople());
            officesVO.setShopSizeEnd(owShop.getShopSizeEnd());
            officesVO.setDeposit(owShop.getDeposit());
            officesVOList.add(officesVO);
        }
        recommendVO.setOfficesVOList(officesVOList);

        List<OwShop> owShopList1 = shopService.recommend(ShopStatusEnum.UP.getCode(),0,1);
        for (OwShop owShop: owShopList1){
            OfficeVO officeVO = new OfficeVO();
            officeVO.setShopImg(owShop.getShopImg());
            officeVO.setShopName(owShop.getShopName());
            officeVO.setName(shopClassService.findOne(1).getName());
            officeVO.setShopPeople(owShop.getShopPeople());
            officeVO.setShopSizeEnd(owShop.getShopSizeEnd());
            officeVO.setDeposit(owShop.getDeposit());
            officeVOList.add(officeVO);
        }
        recommendVO.setOfficeVOList(officeVOList);

        List<OwShop> owShopList2 = shopService.recommend(ShopStatusEnum.UP.getCode(),0,2);
        for (OwShop owShop: owShopList2){
            SeatVO seatVO = new SeatVO();
            seatVO.setShopImg(owShop.getShopImg());
            seatVO.setShopName(owShop.getShopName());
            seatVO.setName(shopClassService.findOne(2).getName());
            seatVO.setShopPeople(owShop.getShopPeople());
            seatVO.setShopSizeEnd(owShop.getShopSizeEnd());
            seatVO.setDeposit(owShop.getDeposit());
            seatVOList.add(seatVO);
        }
        recommendVO.setSeatVOList(seatVOList);

        List<OwShop> owShopList3 = shopService.recommend(ShopStatusEnum.UP.getCode(),0,3);
        for (OwShop owShop: owShopList3){
            MeetingVO meetingVO = new MeetingVO();
            meetingVO.setShopImg(owShop.getShopImg());
            meetingVO.setShopName(owShop.getShopName());
            meetingVO.setName(shopClassService.findOne(3).getName());
            meetingVO.setShopPeople(owShop.getShopPeople());
            meetingVO.setShopSizeEnd(owShop.getShopSizeEnd());
            meetingVO.setDeposit(owShop.getDeposit());
            meetingVOList.add(meetingVO);
        }
        recommendVO.setMeetingVOList(meetingVOList);

        List<OwShop> owShopList4 = shopService.recommend(ShopStatusEnum.UP.getCode(),0,4);
        for (OwShop owShop: owShopList4){
            TrainVO trainVO = new TrainVO();
            trainVO.setShopImg(owShop.getShopImg());
            trainVO.setShopName(owShop.getShopName());
            trainVO.setName(shopClassService.findOne(4).getName());
            trainVO.setShopPeople(owShop.getShopPeople());
            trainVO.setShopSizeEnd(owShop.getShopSizeEnd());
            trainVO.setDeposit(owShop.getDeposit());
            trainVOList.add(trainVO);
        }
        recommendVO.setTrainVOList(trainVOList);

        List<OwShop> owShopList5 = shopService.recommend(ShopStatusEnum.UP.getCode(),0,5);
        for (OwShop owShop: owShopList5){
            BusinessVO businessVO = new BusinessVO();
            businessVO.setShopImg(owShop.getShopImg());
            businessVO.setShopName(owShop.getShopName());
            businessVO.setName(shopClassService.findOne(5).getName());
            businessVO.setShopPeople(owShop.getShopPeople());
            businessVO.setShopSizeEnd(owShop.getShopSizeEnd());
            businessVO.setDeposit(owShop.getDeposit());
            businessVOList.add(businessVO);
        }
        recommendVO.setBusinessVOList(businessVOList);
        dataVO.setRecommendVO(recommendVO);
        indexVO.setData(dataVO);
        indexVO.setCode(0);
        indexVO.setMsg("成功");
        return indexVO;
    }


    /** 找位功能：根据价格范围和工位类型查找，分页处理*/
    @PostMapping("/seat")
    public FindSeatVO findSeat(@RequestParam(value = "page",defaultValue = "0") Integer page,
                               @RequestParam(value = "size",defaultValue = "10") Integer size,
                               @RequestParam("cId")Integer cId,
                               @RequestParam("prices")BigDecimal prices,
                               @RequestParam("prices1")BigDecimal prices1){
        ShopDataVO shopDataVO = new ShopDataVO();
        PageRequest request = new PageRequest(page, size);

        /** 查询所有上架商品*/
        if (cId==10 && prices.equals(new BigDecimal(0)) && prices1.equals(new BigDecimal(100000))){
            Page<FindSeatDTO> findSeatDTOPage = shopService.findStatus(0,request);
            for (FindSeatDTO findSeatDTO: findSeatDTOPage){
                OwShop owShop = shopService.findById(findSeatDTO.getId());
                findSeatDTO.setName(shopClassService.findOne(owShop.getCId()).getName());
                shopDataVO.setFindSeatDTOPage(findSeatDTOPage.getContent());
            } /** 查询所有商品类型，大于10000价格的商品*/
        } else if (cId==10 && prices.equals(new BigDecimal(10000)) && prices1.equals(new BigDecimal(100000))){
            Page<FindSeatDTO> findSeatDTOPage = shopService.noCIdGreaterThan(new BigDecimal(10000),request);
            for (FindSeatDTO findSeatDTO: findSeatDTOPage){
                OwShop owShop = shopService.findById(findSeatDTO.getId());
                findSeatDTO.setName(shopClassService.findOne(owShop.getCId()).getName());
                shopDataVO.setFindSeatDTOPage(findSeatDTOPage.getContent());
            }
        }else if (cId==10 && prices.equals(new BigDecimal(0)) && prices1.equals(new BigDecimal(2000))){
            Page<FindSeatDTO> findSeatDTOPage = shopService.noCIdLessThan(new BigDecimal(2000),request);
            for (FindSeatDTO findSeatDTO: findSeatDTOPage){
                OwShop owShop = shopService.findById(findSeatDTO.getId());
                findSeatDTO.setName(shopClassService.findOne(owShop.getCId()).getName());
                shopDataVO.setFindSeatDTOPage(findSeatDTOPage.getContent());
            }
        }else if (cId==10 && prices!=null && prices1!=null){
            Page<FindSeatDTO> findSeatDTOPage = shopService.noCIdBetween(prices,prices1,request);
            for (FindSeatDTO findSeatDTO: findSeatDTOPage){
                OwShop owShop = shopService.findById(findSeatDTO.getId());
                findSeatDTO.setName(shopClassService.findOne(owShop.getCId()).getName());
                shopDataVO.setFindSeatDTOPage(findSeatDTOPage.getContent());
            }
        }else if (cId!=null && prices==null && prices1==null){
            Page<FindSeatDTO> findSeatDTOPage = shopService.findByCId(cId,request);
            for (FindSeatDTO findSeatDTO: findSeatDTOPage){
                OwShop owShop = shopService.findById(findSeatDTO.getId());
                findSeatDTO.setName(shopClassService.findOne(owShop.getCId()).getName());
                shopDataVO.setFindSeatDTOPage(findSeatDTOPage.getContent());
            }
        }else if(cId!=null && prices.equals(new BigDecimal(10000)) && prices1.equals(new BigDecimal(100000))){
            Page<FindSeatDTO> findSeatDTOPage = shopService.greaterThan(cId,new BigDecimal(10000),request);
            for (FindSeatDTO findSeatDTO: findSeatDTOPage){
                OwShop owShop = shopService.findById(findSeatDTO.getId());
                findSeatDTO.setName(shopClassService.findOne(owShop.getCId()).getName());
                shopDataVO.setFindSeatDTOPage(findSeatDTOPage.getContent());
            }
        }else if (cId!=null && prices.equals(new BigDecimal(0)) && prices1.equals(new BigDecimal(2000))){
            Page<FindSeatDTO> findSeatDTOPage = shopService.lessThan(cId,new BigDecimal(2000),request);
            for (FindSeatDTO findSeatDTO: findSeatDTOPage){
                OwShop owShop = shopService.findById(findSeatDTO.getId());
                findSeatDTO.setName(shopClassService.findOne(owShop.getCId()).getName());
                shopDataVO.setFindSeatDTOPage(findSeatDTOPage.getContent());
            }
        }else if (cId!=null && prices!=null && prices1!=null) {
            Page<FindSeatDTO> findSeatDTOPage = shopService.between(cId, prices, prices1, request);
            for (FindSeatDTO findSeatDTO : findSeatDTOPage) {
                OwShop owShop = shopService.findById(findSeatDTO.getId());
                findSeatDTO.setName(shopClassService.findOne(owShop.getCId()).getName());
                shopDataVO.setFindSeatDTOPage(findSeatDTOPage.getContent());
            }
        }
        return FindSeatVO.success(shopDataVO);
    }

    /** 我的页面，个人信息*/
    @PostMapping("/my")
    public My myInformation(@RequestParam("id")Integer id){
        MyVO myVO = new MyVO();
        OwUser owUser = userService.findById(id);
        myVO.setId(owUser.getId());
        myVO.setPortrait(owUser.getPortrait());
        myVO.setNickname(owUser.getNickname());
        OwUserAccount owUserAccount = userAccountService.findByUserId(id);
        myVO.setUserBalance(owUserAccount.getUserBalance());
        My2 my2 = new My2();
        my2.setMyVO(myVO);
        return My.success(my2);
    }
}
