const mathFunc = require("../input/mathFunction")




describe("currentFuncValue", () => {
    test("should return value of function ", () => {
        expect(mathFunc.currentFuncValue((x) => x + 1, 1)).toBe(2)
    })
    test("should be null if argument === undefined", () => {
        expect(mathFunc.currentFuncValue((x) => x + 1)).toBeNull()
    })
})


describe("makeMathFunc", () => {
    test("should define function", () => {
        expect(mathFunc.makeMathFunc((x) => x)).toBeDefined()
    })

    test("should return math function",() => {
        expect(mathFunc.makeMathFunc((x) => x + 1)().toString()).toEqual(((function foo(x)  { return x + 1 })()).toString())
    })

    test("should be defined", () => {
        expect(mathFunc.makeMathFunc((x) => x + 1))
    })

})

describe("arrayValueOnSegment", () => {
    test("should return array(simple func)", () => {
        expect(mathFunc.arrayValueOnSegment((x) => {return x + 1}, 1, 5, 1, 1)).toEqual([2,3,4,5])
    })

    test("should return array(with sin)", () =>{
        expect(mathFunc.arrayValueOnSegment((x) => {return Math.sin(x)},0,Math.PI,1,Math.PI/2)).toEqual([0, 1])
    })

    test("should return null if segment is not exist", () => {
        expect(mathFunc.arrayValueOnSegment((x) => x)).toBeNull()
    })
})

