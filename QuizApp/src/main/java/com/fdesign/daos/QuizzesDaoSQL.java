package com.fdesign.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fdesign.models.QA;
import com.fdesign.models.QtoU;
import com.fdesign.models.Questions;
import com.fdesign.models.Quizzes;
import com.fdesign.models.QutoQ;
import com.fdesign.util.ConnectionUtil;

public class QuizzesDaoSQL implements QuizzesDao {
	
	//MAGIC STRINGS
	private static final String CREATE_NEW_QUIZ = "INSERT INTO q_quizzes (quiz_id, quiz_title, quiz_description) " + "VALUES (quiz_id_seq.nextval, ?,?)";
	
	private static final String CREATE_NEW_QUEST_WITH_ANS = "call createquestandkey(?,?,?,?,?,?)";
	
	private static final String ASSIGN_QUEST_TO_QUIZ = "INSERT INTO q_quiz_with_questions (quiz_id, question_id) " + "VALUES (?,?)";
	
	private static final String ASSIGN_QUIZ_TO_USER = "INSERT INTO q_results (user_id, quiz_id) " + "VALUES (?,?)";
	
	private static final String UPDATE_QUIZ_RESULTS = "UPDATE q_results SET results_grade = ? " + "WHERE user_id = ? AND quiz_id = ?";
	
	private static final String RETRIEVE_ALL_QUIZZES = "SELECT * FROM q_quizzes";
	
	private static final String RETRIEVE_ALL_QUESTIONS = "SELECT * FROM q_questions";
	
	private static final String RETRIEVE_ALL_QUIZZES_ASSIGN_TO_USER = "SELECT qr.user_id, qr.quiz_id, qq.quiz_title, qq.quiz_description, qr.results_grade\n" +
	
																	"FROM q_results qr \n" +

																	"LEFT JOIN q_quizzes qq ON (qr.quiz_id = qq.quiz_id) \n" +

																	"WHERE qr.user_id = ?";
	
	private static final String RETRIEVE_ALL_QUIZZES_ASSIGN_TO_USERS = "SELECT qr.user_id, qr.quiz_id, qq.quiz_title, qq.quiz_description, qr.results_grade\n" + 

																	"FROM q_results qr \n" + 

																	"LEFT JOIN q_quizzes qq ON (qr.quiz_id = qq.quiz_id)";
	
	private static final String RETRIEVE_ALL_QUESTS_ASSIGN_TO_QUIZ = "SELECT qwq.quiz_id, qwq.question_id, qqu.question_description, qqu.question_response_1, qqu.question_response_2, qqu.question_response_3, qqu.question_response_4\n" +
			
																	"FROM q_quiz_with_questions qwq \n" + 

																	"LEFT JOIN q_questions qqu ON (qwq.question_id = qqu.question_id) \n" +

																	"WHERE qwq.quiz_id = ?";
	
	private static final String RETRIEVE_ALL_QUESTS_ASSIGN_TO_QUIZZES = "SELECT qwq.quiz_id, qwq.question_id, qqu.question_description, qqu.question_response_1, qqu.question_response_2, qqu.question_response_3, qqu.question_response_4\n" +
			
																	"FROM q_quiz_with_questions qwq \n" + 
																	
																	"LEFT JOIN q_questions qqu ON (qwq.question_id = qqu.question_id)";

	Quizzes extractQuizes(ResultSet rs) throws SQLException {
		
		int qid = rs.getInt("quiz_id");
		String rsQuizTitle = rs.getString("quiz_title");
		String rsQuizDescription = rs.getString("quiz_description");
		return new Quizzes(qid, rsQuizTitle, rsQuizDescription);
		
	}
	
	Questions extractQuestions(ResultSet rs) throws SQLException {
		
		int quid = rs.getInt("question_id");
		String rsQuestDesc = rs.getString("question_description");
		String rsQuestRes1 = rs.getString("question_response_1");
		String rsQuestRes2 = rs.getString("question_response_2");
		String rsQuestRes3 = rs.getString("question_response_3");
		String rsQuestRes4 = rs.getString("question_response_4");
		return new Questions(quid, rsQuestDesc, rsQuestRes1, rsQuestRes2, rsQuestRes3, rsQuestRes4);
		
	}
	
	QA extractQA(ResultSet rs) throws SQLException {
		String rsQADesc = rs.getString("question_description");
		String rsQARes1 = rs.getString("question_response_1");
		String rsQARes2 = rs.getString("question_response_2");
		String rsQARes3 = rs.getString("question_response_3");
		String rsQARes4 = rs.getString("question_response_4");
		String rsQAA = rs.getString("answer");
		return new QA(rsQADesc, rsQARes1, rsQARes2, rsQARes3, rsQARes4, rsQAA);
	}
	
	QtoU extractQtoU(ResultSet rs) throws SQLException {
		
		int rsUid = rs.getInt("user_id");
		int rsQid = rs.getInt("quiz_id");
		String rsQTitle = rs.getString("quiz_title");
		String rsQDesc = rs.getString("quiz_description");
		double rsResultsGrade = rs.getDouble("results_grade");
		return new QtoU(rsUid, rsQid, rsQTitle, rsQDesc, rsResultsGrade);
	}
	
	QutoQ extractQutoQ(ResultSet rs) throws SQLException {
		int  rsQQid = rs.getInt("quiz_id");
		int  rsQQuid = rs.getInt("question_id");
		String rsQQDesc = rs.getString("question_description");
		String rsQQRes1 = rs.getString("question_response_1");
		String rsQQRes2 = rs.getString("question_response_2");
		String rsQQRes3 = rs.getString("question_response_3");
		String rsQQRes4 = rs.getString("question_response_4");
		return new QutoQ(rsQQid, rsQQuid, rsQQDesc, rsQQRes1, rsQQRes2, rsQQRes3, rsQQRes4);
	}

	@Override
	public int createNewQuiz(Quizzes q) {
		try (Connection c = ConnectionUtil.getConnection()) {
			
			PreparedStatement ps = c.prepareStatement(CREATE_NEW_QUIZ);
			ps.setString(1, q.getQuiz_title());
			ps.setString(2, q.getQuiz_description());
			
			return ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int createNewQuWithAns(QA qa) {
		try (Connection c = ConnectionUtil.getConnection()){
			
			PreparedStatement ps = c.prepareCall(CREATE_NEW_QUEST_WITH_ANS);
			ps.setString(1, qa.getQuestion_description());
			ps.setString(2, qa.getQuestion_response_1());
			ps.setString(3, qa.getQuestion_response_2());
			ps.setString(4, qa.getQuestion_response_3());
			ps.setString(5, qa.getQuestion_response_4());
			ps.setString(6, qa.getAnswer());
			
			return ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public Quizzes AssignQuestionsToQuiz(int quiz_id, int question_id) {
		try (Connection c = ConnectionUtil.getConnection()) {
			
			PreparedStatement ps= c.prepareStatement(ASSIGN_QUEST_TO_QUIZ);
			ps.setInt(1, quiz_id);
			ps.setInt(2, question_id);
			ps.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Quizzes AssignQuizToUser(int user_id, int quiz_id) {
		try (Connection c = ConnectionUtil.getConnection()) {
			
			PreparedStatement ps = c.prepareStatement(ASSIGN_QUIZ_TO_USER);
			ps.setInt(1, user_id);
			ps.setInt(2, quiz_id);
			ps.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public void updateQuizResults(double results_grade, int user_id, int quiz_id) {
		try (Connection c = ConnectionUtil.getConnection()) {
			
			PreparedStatement ps = c.prepareStatement(UPDATE_QUIZ_RESULTS);
			ps.setDouble(1, results_grade);
			ps.setInt(2, user_id);
			ps.setInt(3, quiz_id);
			ps.executeQuery();
			
			return;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Quizzes> retrieveAllQuizzes() {
		try (Connection c = ConnectionUtil.getConnection()) {
			
			PreparedStatement ps = c.prepareStatement(RETRIEVE_ALL_QUIZZES);
			
			ResultSet rs = ps.executeQuery();
			List<Quizzes> quizes = new ArrayList<Quizzes>();
			while (rs.next()) {
				quizes.add(extractQuizes(rs));
			}
			
			return quizes;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Questions> retrieveAllQuestions() {
		try (Connection c = ConnectionUtil.getConnection()) {
			
			PreparedStatement ps = c.prepareStatement(RETRIEVE_ALL_QUESTIONS);
			
			ResultSet rs = ps.executeQuery();
			List<Questions> questions = new ArrayList<Questions>();
			while (rs.next()) {
				questions.add(extractQuestions(rs));
			}
			
			return questions;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<QtoU> retrieveAllQuizzesAssignedToUsers() {
		try (Connection c = ConnectionUtil.getConnection()) {
			
			PreparedStatement ps = c.prepareStatement(RETRIEVE_ALL_QUIZZES_ASSIGN_TO_USERS);
			
			ResultSet rs = ps.executeQuery();
			List<QtoU> qtou = new ArrayList<QtoU>();
			while (rs.next()) {
				qtou.add(extractQtoU(rs));
			}
			
			return qtou;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<QtoU> retrieveAllQuizzesAssignedToUser(int user_id) {
		try (Connection c = ConnectionUtil.getConnection()) {
			
			PreparedStatement ps = c.prepareStatement(RETRIEVE_ALL_QUIZZES_ASSIGN_TO_USER);
			ps.setInt(1, user_id);
			
			ResultSet rs = ps.executeQuery();
			List<QtoU> qtou = new ArrayList<QtoU>();
			while (rs.next()) {
				qtou.add(extractQtoU(rs));
			}
			
			return qtou;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<QutoQ> retrieveAllQuestsAssignedtoQuiz(int quiz_id) {
		try (Connection c = ConnectionUtil.getConnection()) {
			
			PreparedStatement ps = c.prepareStatement(RETRIEVE_ALL_QUESTS_ASSIGN_TO_QUIZ);
			ps.setInt(1, quiz_id);
			
			ResultSet rs = ps.executeQuery();
			List<QutoQ> qutoq = new ArrayList<QutoQ>();
			while (rs.next()) {
				qutoq.add(extractQutoQ(rs));
			}
			
			return qutoq;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<QutoQ> retrieveAllQuestsAssignedtoQuizzes() {
		try (Connection c = ConnectionUtil.getConnection()) {
			
			PreparedStatement ps = c.prepareStatement(RETRIEVE_ALL_QUESTS_ASSIGN_TO_QUIZZES);
			
			ResultSet rs = ps.executeQuery();
			List<QutoQ> qutoq = new ArrayList<QutoQ>();
			while (rs.next()) {
				qutoq.add(extractQutoQ(rs));
			}
			
			return qutoq;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
