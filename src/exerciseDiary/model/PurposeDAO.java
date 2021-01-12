package exerciseDiary.model;

import javax.persistence.EntityManager;

import exerciseDiary.exception.NotExistException;
import exerciseDiary.model.entity.Purpose;
import exerciseDiary.util.PublicCommon;

public class PurposeDAO {
	public static Purpose findPurpose(String uPurpose) throws Exception {
		EntityManager em = PublicCommon.getEntityManager();
		Purpose p = null;

		try {
			p = (Purpose) em.createNativeQuery("select * from purpose where purpose=?", Purpose.class)
					.setParameter(1, uPurpose).getSingleResult();

			if (p == null) {
				throw new NotExistException("select purpose 실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			em.close();
		}
		return p;
	}
}
