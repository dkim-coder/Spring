import { name, add, addr as myaddr, age } from "./export_multi.js";
import greeting from "./export_default.js";     // 단일만 반환될 시 import 다름 이름 지정 가능

console.log(name, myaddr, age);

greeting.sayHello.kor(name);

export { name, add, myaddr, age, greeting };
