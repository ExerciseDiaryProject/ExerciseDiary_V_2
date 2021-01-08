package excerciseDiary.controller;

import exerciseDiary.controller.action.Action;
import exerciseDiary.controller.action.addDiary;
import exerciseDiary.controller.action.addUser;
import exerciseDiary.controller.action.checkUser;
import exerciseDiary.controller.action.deleteDiary;
import exerciseDiary.controller.action.deleteUser;
import exerciseDiary.controller.action.getAllVideoList;
import exerciseDiary.controller.action.getDiaryDetail;
import exerciseDiary.controller.action.getDiaryList;
import exerciseDiary.controller.action.getUser;
import exerciseDiary.controller.action.getVideoList;
import exerciseDiary.controller.action.updateUserPurpose;
import exerciseDiary.controller.action.updateUserReq;

public class ActionFactory {
	private static ActionFactory instance = new ActionFactory();
	private ActionFactory(){}
	public static ActionFactory getInstance(){
		return instance;
	}
	public Action getAction(String command){
		Action action = null;
		
		if(command.equals("signUp")){ // 회원가입
			action = new addUser();
		} else if(command.equals("logIn")){ // 로그인
			action = new checkUser();
		} else if(command.equals("getUser")){ // 마이페이지
			action = new getUser();
		} else if(command.equals("updateUserReq")){ // 마이페이지 user 정보 수정
			action = new updateUserReq();
		} else if(command.equals("updateUserPurpose")){ // 마이페이지 user 운동목적 수정
			action = new updateUserPurpose();
		} else if(command.equals("deleteUser")){ // 마이페이지 user 정보 삭제
			action = new deleteUser();
		} else if(command.equals("purpose")){ // 운동목적별 영상 list 반환
			action = new getVideoList();
		} else if(command.equals("getAllVideoList")){ // 모든 영상 list 반환
			action = new getAllVideoList();
		} else if(command.equals("addDiary")) { // 다이어리 작성 추가
			action = new addDiary();
		} else if(command.equals("deleteDiary")) { // 다이어리 삭제
			action = new deleteDiary();	
		} else if(command.equals("getDiaryList")) { // 다이어리 list 반환
			action = new getDiaryList();	
		} else if(command.equals("getDiaryDetail")) { // 다이어리 상세 보기
			action = new getDiaryDetail();	
		}
		return action;
	} 
}