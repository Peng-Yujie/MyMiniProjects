import React from "react";
import { useQuizContext } from "../contexts/QuizContext";

function NextButton() {
  const { index, noOfQuestions, answer, dispatch } = useQuizContext();

  if (answer === null) return null;
  if (index < noOfQuestions - 1) {
    return (
      <button
        className="btn btn-ui"
        onClick={() => dispatch({ type: "nextQuestion" })}
      >
        Next
      </button>
    );
  } else if (index === noOfQuestions - 1) {
    return (
      <button
        className="btn btn-ui"
        onClick={() => dispatch({ type: "finish" })}
      >
        Finish
      </button>
    );
  }
}

export default NextButton;
