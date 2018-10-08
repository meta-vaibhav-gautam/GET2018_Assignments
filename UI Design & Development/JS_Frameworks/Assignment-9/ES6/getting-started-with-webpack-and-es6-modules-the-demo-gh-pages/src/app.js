import {sayHello} from './modules/greeting';
import {sum} from './modules/math-functions';

const resultGreeting = document.getElementById('resultGreeting');
const resultSum = document.getElementById('resultSum');

const a = 3;
const b = 7;

resultGreeting.textContent = sayHello('Nice to see you! 🙂');
resultSum.textContent = `The sum of ${a} and ${b} using sum(a,b) is: ${sum(a, b)} and using sun(a)(b) is: ${sum(a)(b)}. ✨`;
