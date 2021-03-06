package exerciseDiary.model;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import exerciseDiary.model.entity.Diary;
import exerciseDiary.util.PublicCommon;

public class DiaryDAO {

	// 다이어리 작성
	public static boolean addDiary(Diary diary) throws SQLException {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();

		tx.begin();

		try {
			em.persist(diary);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
			throw e;

		} finally {
			em.close();
		}
		return true;
	}

	// 다이어리 삭제
	public static boolean deleteDiary(int diaryNo) {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();

		tx.begin();

		try {
			int result = em.createNativeQuery("delete from diary where diary_no=?").setParameter(1, diaryNo)
					.executeUpdate();
			tx.commit();
			if (result == 1) {
				return true;
			}

		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
			throw e;

		} finally {
			em.close();
		}
		return false;
	}

	// **********************수정 필요(리스트에 보여질 데이터)**********************
	// 다이어리 list 반환
	public static ArrayList<Diary> getDiaryList(String userId) throws SQLException {
		EntityManager em = PublicCommon.getEntityManager();
		ArrayList<Diary> diaryList = null;

		try {
			diaryList = (ArrayList) em.createNativeQuery("select * from diary where user_id=?", Diary.class)
					.setParameter(1, userId).getResultList();

		} catch (Exception e) {
			e.printStackTrace();
			throw e;

		} finally {
			em.close();
		}
		return diaryList;
	}

	// 다이어리 상세보기
	public static Diary getDiaryDetail(String diaryNo) throws SQLException {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();

		Diary diary = null;
		int diaryNum = Integer.parseInt(diaryNo);

		tx.begin();

		try {
			diary = em.find(Diary.class, diaryNum);
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
			throw e;

		} finally {
			em.close();
		}
		return diary;
	}
}
