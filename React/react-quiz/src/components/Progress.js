import React from "react";
import { useQuizContext } from "../contexts/QuizContext";

function Progress() {
  const { noOfQuestions, index, answer, points, maxPossiblePoints } =
    useQuizContext();

  return (
    <header className="progress">
      <progress max={noOfQuestions} value={index + Number(answer !== null)} />
      <p>
        Question <strong>{index + 1}</strong> / {noOfQuestions}
      </p>
      <p>
        <strong>{points}</strong> / {maxPossiblePoints}
      </p>
    </header>
  );
}

export default Progress;
