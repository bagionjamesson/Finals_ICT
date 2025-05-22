package com.example.quiz.service;

import com.example.quiz.model.QuizQuestion;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuizService {

    // In a real application, this data would likely come from a database.
    private static final List<QuizQuestion> questions = new ArrayList<>();

    static {
        questions.add(new QuizQuestion(
            "What does ABS stand for?",
            Arrays.asList("Automatic Braking System", "Anti-lock Braking System", "Advanced Brake Safety"),
            "Anti-lock Braking System"
        ));
        questions.add(new QuizQuestion(
            "Which company manufactures the Mustang?",
            Arrays.asList("Chevrolet", "Ford", "Dodge"),
            "Ford"
        ));
        questions.add(new QuizQuestion(
            "What type of engine uses a spark plug to ignite the fuel?",
            Arrays.asList("Diesel engine", "Electric motor", "Gasoline engine"),
            "Gasoline engine"
        ));
        questions.add(new QuizQuestion(
            "What is the main purpose of a catalytic converter?",
            Arrays.asList("Increase engine power", "Reduce harmful emissions", "Improve fuel efficiency"),
            "Reduce harmful emissions"
        ));
        questions.add(new QuizQuestion(
            "Where is the automotive brand Toyota headquartered?",
            Arrays.asList("South Korea", "Germany", "Japan"),
            "Japan"
        ));
    }

    public List<QuizQuestion> getAllQuestions() {
        return new ArrayList<>(questions); // Return a copy
    }

    // You could add methods here to get a question by ID, add new questions, etc.
    // You might also have logic to check answers on the server.
}// This is pseudo-code for an API controller
// In a Spring Boot application, this might be in a file like QuizController.java
// @RestController
// @RequestMapping("/api/quiz")
// public class QuizController {
//
//     @Autowired
//     private QuizService quizService;
//
//     @GetMapping("/questions")
//     public List<QuizQuestion> getQuestions() {
//         return quizService.getAllQuestions();
//     }
// }
let quizData = []; // Initialize as empty

async function fetchQuizData() {
  try {
    const response = await fetch('/api/quiz/questions'); // URL of your Java API endpoint
    if (!response.ok) {
      throw new Error(`HTTP error! status: ${response.status}`);
    }
    quizData = await response.json();
    // Now quizData is populated from the server, you can proceed to start the quiz
    // For example, enable the start button or call a function that uses quizData
  } catch (error) {
    console.error("Could not fetch quiz data:", error);
    // Handle error, maybe display a message to the user
  }
}

// Call this function when the page loads or when you're ready to get questions
// fetchQuizData();
// You'd then adjust your startQuiz function to ensure quizData is loaded before proceeding.
