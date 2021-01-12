package exerciseDiary.model;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import exerciseDiary.exception.NotExistException;
import exerciseDiary.model.entity.Diary;
import exerciseDiary.model.entity.Purpose;
import exerciseDiary.model.entity.Video;
import exerciseDiary.util.PublicCommon;

public class VideoDAO {

	// 모든 영상 반환
	public static ArrayList<Video> getAllVideoList() throws SQLException {
		EntityManager em = PublicCommon.getEntityManager();
		ArrayList<Video> videoList = null;

		try {
			videoList = (ArrayList) em.createNativeQuery("select * from video", Video.class).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;

		} finally {
			em.close();
		}
		return videoList;
	}

	// 운동 목적별 영상 list 반환
	public static ArrayList<Video> getVideoList(String purpose) throws SQLException {
		EntityManager em = PublicCommon.getEntityManager();
		ArrayList<Video> videoList = null;
		try {
			videoList = (ArrayList) em.createNativeQuery("select * from video where purpose=?", Video.class)
					.setParameter(1, purpose).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;

		} finally {
			em.close();
		}
		return videoList;
	}

	// 운동 목적별 영상 list 반환
	public static Video getVideoDetail(String playlist) throws SQLException {
		EntityManager em = PublicCommon.getEntityManager();
		Video video = null;
		try {
			video = (Video) em.createNativeQuery("select * from video where playlist=?", Video.class)
					.setParameter(1, playlist).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;

		} finally {
			em.close();
		}
		return video;
	}

	public static Video findProgram(String program) throws Exception {
		EntityManager em = PublicCommon.getEntityManager();
		Video v = null;

		try {
			v = (Video) em.createNativeQuery("select * from video where program_no=?", Video.class)
					.setParameter(1, program).getSingleResult();

			if (v == null) {
				throw new NotExistException("select Video 실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			em.close();
		}
		return v;
	}

}
