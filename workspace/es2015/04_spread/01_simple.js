// spread operator
let normal = {
  name: "hong",
  age: 30,
};

let oldHero = {
  name: normal.name,
  age: normal.age,
  nick: "율도국왕",
};

console.log(oldHero);

let newHero = {
  ...oldHero,   // 스프레드 연산자 -> 기존의 객체, 배열의 값을 다른 객체나 배열로 복제하거나 옮길 때 사용
  wish: `아버지를 아버지라고 부르고 싶어함.`,
};

console.log(newHero);

const originalArray = [1, { value: 10 }, 3];
const copiedArray = [...originalArray];

copiedArray[0] = 100; // 복사된 배열의 원시값 변경
copiedArray[1].value = 20; // 복사된 배열의 객체 속성 변경

console.log(originalArray[0]);
console.log(originalArray[1].value);
