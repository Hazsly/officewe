package com.guorui.officewe.vo.index;

import lombok.Data;

import java.util.List;


/**
 * @author Hazsly
 * @date 2018/2/5 16:05
 */
@Data
public class RecommendVO {

    private List<OfficesVO> officesVOList;

    private List<OfficeVO> officeVOList;

    private List<SeatVO> seatVOList;

    private List<MeetingVO> meetingVOList;

    private List<TrainVO> trainVOList;

    private List<BusinessVO> businessVOList;
}
