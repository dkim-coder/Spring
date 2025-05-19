const nums = { num1: 10000, num2: 20000 }
let sum = 0
let multi = 0

const sumNums = () => {
  sum = 0
  for (let key in nums) {
    sum += nums[key]
  }
}

const multiNums = () => {
  multi = 1
  for (let key in nums) {
    multi *= nums[key]
  }
}

sumNums()
multiNums()

console.log(`기본: nums: ${JSON.stringify(nums)}, sum: ${sum}, multi: ${multi}`)
nums["num3"] = 3
console.log(`추가: nums: ${JSON.stringify(nums)}, sum: ${sum}, multi: ${multi}`)

// TODO: proxy를 이용해서 nums의 속성이 수정되거나 추가될 때 sum과 multi가 계산되도록 처리하시오.
const numsProxy = new Proxy(nums,{
  set(target, prop, value) {
    target[prop] = value;
    sumNums();
    multiNums();
  },
  get(target, prop){
    return new Intl.NumberFormat().format(target[prop]);
  }
});
numsProxy.num4 = 100;
console.log(`proxy 후: nums: ${JSON.stringify(numsProxy)}, sum: ${sum}, multi: ${multi}`);
console.log(numsProxy.num1);