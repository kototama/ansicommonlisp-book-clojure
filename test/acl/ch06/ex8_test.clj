(ns acl.ch06.ex8-test
  (:use clojure.test
        acl.ch06.ex8))

(deftest test-frugal
  (let [current (System/currentTimeMillis)
        res (frugal 44)
        firstcall (System/currentTimeMillis)
        res2 (frugal 44)
        secondcall (System/currentTimeMillis)
        diff1 (- firstcall current)
        diff2 (- secondcall firstcall)]
    (is (and (> diff1 diff2) (< diff2 4000)))))

(deftest test-frugal2
  (let [current (System/currentTimeMillis)
        res (frugal2 44)
        firstcall (System/currentTimeMillis)
        res2 (frugal2 44)
        secondcall (System/currentTimeMillis)
        diff1 (- firstcall current)
        diff2 (- secondcall firstcall)]
    (is (and (> diff1 diff2) (< diff2 4000)))))
