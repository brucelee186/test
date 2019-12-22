// 1. 正则表达式规则
// 1.1 普通字符
var p = /c/;
var s = 'abcde';
var r = p.test(s);
//alert('/c/.test(\'abced\') = '+ r)

p = /bcde/;
r = s.match(p);
//alert(r);

p = /\a/;
r = p.test(s);
//alert(r);

r = /^a/.test(s);
//alert(r);

// 匹配以a开头的字符
r = /^a/.test('ABC');
// alert(r)\

// 匹配以a结尾的字符
r = /a$/.test('cba');
//alert(r)

// *匹配零次或一次
r = /a*/.test('cba');
//alert(r)

// +匹配一次或多次
r = /a+/.test('cba');
//alert(r)

// ?匹配一次或零次
r = /a?/.test('cb');
//alert(r)

// (x)捕捉之后会被自动记录,结果为abc,b
r = /a(b)c/.exec('abccddd');
//alert(r);

// x|y匹配字符串中是否含有x或
r = /x|y/.test('xyzaaa');
//alert(r);

// {n}精确匹配n次
// [bcd]{2}相当于[bcd][bcd]
r = /a{2}/.test('xyaaa');
//alert(r)

// {n,}精确匹配n次及n次以上
r = /a{2,}/.test('xyaaa')
//alert(r)

// {m,n}精确匹配m~n次
r = /a{2,3}/.exec('syaaaa');
//alert(r)

// [xyz]匹配中括号中的任意一个值
r = /[xyz]/.test('aaazy');
//alert(r)

// [^xyz]过滤找包含xyz的字符
r = /[^xyz]/.test('aaaaaabxzy');
//alert(r)

// [\b] 匹配一个退格符
r = /[\b]/.test('\b');
//alert(r)

// 一 javascript正则表达式的基本知识

// 1 Javascript 正则对象创建 和用法

// 声明javascript 正则表达式
// 方式1
var regExp = new RegExp("cat");
// 方式2
var pattern = /cat/;

//2 学习最常用的 test exec match search  replace  split 6个方法
//1） test  检查指定的字符串是否存在
var s = '123456';
// 继续住下走,i不区别大小写
var p = /123/gi;
var r = p.test(s);
//alert(r)

//2) exec返回值查询
s = '123123,213,12312,312,3,Cat,cat,dsfsdfs,';
// i不区别大小写,
// 返回第一个查询的值
p = /cat/i;
r = p.exec(s);
//alert(r)

//3) match 得到查询数组
s = '123123,213,12312,312,3,Cat,cat,dsfsdfs,';
// g一直向下查询,不加g只会返回第一个值
p = /cat/gi;
r = s.match(p);
//alert(r);

//4) search 返回搜索位置,类型于indexOf
r = s.search(p);
//alert(r);

//5) replace 利用正则表达式替换
p = /cat/gi
r = s.replace(p, 'dog');
//alert(r);

//6) split利用正则分割数组
p = /,/
r = s.split(p);
for ( var int = 0; int < r.length; int++) {
//	alert(r[int]);
}

//3  学习下  简单类   负向类  范围类  组合类
//3.1 简单类
s = 'libinqq1,libinqq2,libinqq3,libinqq4,libinqq5';
p = /nqq[123]/gi;
r = s.match(p);
//alert(r);

// 3.2 负向类
// [^a123]其中的^表示排除以a,1,2,3开关的所有元素
s = 'alibinqq,1libinqq,2libinqq,3libinqq,4libinqq';
p = /[^a123]libinqq/gi;
r = s.match(p);
//alert(r);

// 3.3 范围类
// [1-4]表示结尾为2到4之间的值
s = 'libinqq1,libinqq2,libinqq3,libinqq4,libinqq5';
p = /nqq[2-4]/gi;
r = s.match(p);
//alert(r)

// 3.4 组合类
s = '';