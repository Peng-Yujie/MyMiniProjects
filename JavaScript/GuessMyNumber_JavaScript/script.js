'use strict';

let secretNumber = Math.trunc(Math.random() * 20) + 1;
let score = 20;
let highScore = 0;

// const displayMessage = function (message) {
//   document.querySelector('.message').textContent = message;
// }
// const displayScore = function (score) {
//   document.querySelector('.score').textContent = score;
// }

const displayInfo = function (classname, content) {
  document.querySelector(classname).textContent = content;
}

document.querySelector('.check').addEventListener('click', function () {
  const guess = Number(document.querySelector('.guess').value);
  // console.log(guess, typeof guess);

  //No input
  if (!guess) {
    displayInfo('.message', 'No number!');

    //Win the game
  } else if (guess == secretNumber) {
    displayInfo('.message', 'Correct number!');
    displayInfo('.number', secretNumber);
    // document.querySelector('.number').textContent = secretNumber;

    document.querySelector('body').style.backgroundColor = '#60b347';
    document.querySelector('.number').style.width = '30rem';

    //Record highscore
    if (score > highScore) {
      highScore = score;
      displayInfo('.highscore', highScore);
      // document.querySelector('.highscore').textContent = highScore;
    }

    //Wrong guess
  } else if (guess !== secretNumber) {
    if (score > 1) {
      displayInfo('.message', guess > secretNumber ? 'Too high!' : 'Too low!');
      score--;
      displayInfo('.score', score);
    } else {
      displayInfo('.message', 'You lose!');
      displayInfo('.score', 0);
    }
  }
});

document.querySelector('.again').addEventListener('click', function () {
  secretNumber = Math.trunc(Math.random() * 20) + 1;
  score = 20;

  displayInfo('.message', 'Start guessing...');
  displayInfo('.score', score);
  displayInfo('.number', '?');
  document.querySelector('.guess').value = '';

  document.querySelector('.number').style.width = '15rem';
  document.querySelector('body').style.backgroundColor = '#222';
})