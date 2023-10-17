'use strict';

const btnNew = document.querySelector('.btn--new');
const btnRoll = document.querySelector('.btn--roll');
const btnHold = document.querySelector('.btn--hold');

const player0 = document.querySelector('.player--0');
const player1 = document.querySelector('.player--1');
const score0 = document.getElementById('score--0');
const score1 = document.getElementById('score--1');
const current0 = document.getElementById('current--0');
const current1 = document.getElementById('current--1');
const dice = document.querySelector('.dice');

let scores, playing, currentScore, activePlayer;

const init = () => {
  scores = [0, 0];
  playing = true;
  currentScore = 0;
  activePlayer = 0;

  score0.textContent = 0;
  score1.textContent = 0;
  current0.textContent = 0;
  current1.textContent = 0;

  dice.classList.add('hidden');
  player0.classList.remove('player--winner');
  player1.classList.remove('player--winner');
  player0.classList.add('player--active');//if exists js doesn't add it again
  player1.classList.remove('player--active');
  document.getElementById(`name--0`).textContent = 'Player1';
  document.getElementById(`name--1`).textContent = 'Player2';
};
init();

const rollDice = () => {
  if (playing) {
    //Generate a random dice roll
    let diceNum = Math.floor(Math.random() * 6) + 1;

    //Display Dice
    dice.classList.remove('hidden');
    //`${}`
    dice.src = `dice-${diceNum}.png`;
    console.log(diceNum);

    //Count score
    if (diceNum == 1) {
      switchSide();
    } else {
      currentScore += diceNum;
      document.getElementById(`current--${activePlayer}`).textContent = currentScore;
    }
  }
};

const hold = () => {
  if (playing) {
    scores[activePlayer] += currentScore;
    document.getElementById(`score--${activePlayer}`).textContent = scores[activePlayer];
    if (scores[activePlayer] >= 10) {
      //Winner
      playing = false;
      dice.classList.add('hidden');
      document.getElementById(`name--${activePlayer}`).textContent = 'Winner!';
      document.querySelector(`.player--${activePlayer}`).classList.remove('player--active');
      document.querySelector(`.player--${activePlayer}`).classList.add('player--winner');
    } else {
      switchSide();
    }
  }
};

const switchSide = () => {
  currentScore = 0;
  document.getElementById(`current--${activePlayer}`).textContent = 0;
  activePlayer = activePlayer == 0 ? 1 : 0;
  player0.classList.toggle('player--active');
  player1.classList.toggle('player--active');
};

btnRoll.addEventListener('click', rollDice);
btnHold.addEventListener('click', hold);
btnNew.addEventListener('click', init);