// property short hand & concise method
let language = "javascript";
let oldStyle = {
  language: language,
  sayLang: function () {
    console.log(`사용 언어는 ${this.language} 이다.`);
  },
};

let newStyle = {
  language,   // 객체의 속성 이름과 참조하려는 변수의 이름이 같을 경우는 하나만 사용
  sayLang() {   // 객체에 함수 정의 시 속성 이름을 함수 이름으로 사용
    console.log(`사용 언어는 ${this.language} 이다.`);
  },
};
