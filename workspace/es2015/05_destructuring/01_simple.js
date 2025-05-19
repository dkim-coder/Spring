// 객체 구조 분해
const customer = {
  cname: "김영희",
  age: 28,
  job: "디자이너",
  address: {
    city: "서울",
    district: "강남구",
  },
};
const { cname, age, job, address } = customer;
console.log(cname); // '김영희'
customer.address.city = "광주";   // 객체는 참조형이므로, 원본 객체의 속성값을 변경하면 구조 분해 할당한 변수도 변경된다.
console.log(address);

const {
  cname: cname2,  // __이름 바꾸기__
  job,
  address: { city },
} = customer;
console.log(cname2, city);

// 배열 구조 분해, 순서대로 매핑
const numbers = [1, 2, 3, 4, 5];
const [first, second, ...rest] = numbers;
console.log(first); // 1
console.log(second); // 2
console.log(rest); // [3, 4, 5]
