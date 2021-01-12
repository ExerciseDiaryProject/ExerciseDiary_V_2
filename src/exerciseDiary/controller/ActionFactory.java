package exerciseDiary.controller;

import exerciseDiary.controller.action.Action;
import exerciseDiary.controller.action.AddDiary;
import exerciseDiary.controller.action.AddUser;
import exerciseDiary.controller.action.CheckUser;
import exerciseDiary.controller.action.UserLogout;
import exerciseDiary.controller.action.DeleteDiary;
import exerciseDiary.controller.action.DeleteUser;
import exerciseDiary.controller.action.GetAllVideoList;
import exerciseDiary.controller.action.GetDiaryDetail;
import exerciseDiary.controller.action.GetDiaryList;
import exerciseDiary.controller.action.GetUser;
import exerciseDiary.controller.action.GetVideoDetail;
import exerciseDiary.controller.action.GetVideoList;
import exerciseDiary.controller.action.UpdateUserPurpose;
import exerciseDiary.controller.action.UpdateUserReq;

public class ActionFactory {
	private static ActionFactory instance = new ActionFactory();
	private ActionFactory(){}
	public static ActionFactory getInstance(){
		return instance;
	}
	public Action getAction(String command){
		Action action = null;
		
		if(command.equals("signUp")){ // 회원가입
			action = new AddUser();
		} else if(command.equals("logIn")){ // 로그인
			action = new CheckUser();
		} else if(command.equals("logout")) { // 로그아웃
			action = new UserLogout();
		} else if(command.equals("getUser")){ // 마이페이지
			action = new GetUser();
		} else if(command.equals("updateUserReq")){ // 마이페이지 user 정보 수정
			action = new UpdateUserReq();
		} else if(command.equals("updateUser")){ // 마이페이지 user 운동목적 수정
			action = new UpdateUserPurpose();
		} else if(command.equals("deleteUser")){ // 마이페이지 user 정보 삭제
			action = new DeleteUser();
		} else if(command.equals("purpose")){ // 운동목적별 영상 list 반환
			action = new GetVideoList();
		} else if(command.equals("getAllVideoList")){ // 모든 영상 list 반환
			action = new GetAllVideoList();
		} else if(command.equals("addDiary")) { // 다이어리 작성 추가
			action = new AddDiary();
		} else if(command.equals("deleteDiary")) { // 다이어리 삭제
			action = new DeleteDiary();	
		} else if(command.equals("getDiaryList")) { // 다이어리 list 반환
			action = new GetDiaryList();	
		} else if(command.equals("getDiaryDetail")) { // 다이어리 상세 보기
			action = new GetDiaryDetail();	
		} else if(command.equals("getVideoDetail")) { // 비디오 상세 보기
			action = new GetVideoDetail();	
		}
		return action;
	} 
}