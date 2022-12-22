package com.booking.service;

import com.booking.entity.Question;
import com.booking.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService{

	@Autowired
	QuestionRepository questionRepository;


	@Override
	public List<Question> getAllQuestions() {
		return questionRepository.findAll();
	}
}
