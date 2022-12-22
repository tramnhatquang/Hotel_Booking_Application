package com.booking.service;

import com.booking.entity.Question;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface QuestionService {
	List<Question> getAllQuestions();
}
