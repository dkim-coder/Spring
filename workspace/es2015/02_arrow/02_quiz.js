// quiz 01.
const createConfig = (port) => ({   // 객체인지 함수인지 애매하니 () 로 묶어서 객체 표시
  host: "localhost",
  port: port
});

const config = createConfig(8080);
console.log(config);

// quiz 02.
const result = ((x) => x * x)(5);   // 즉시 실행 함수

console.log(result);
