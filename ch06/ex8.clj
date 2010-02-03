(use 'clojure.test)

(defn expensive [n]
  (Thread/sleep 5000)
  (* n n))

(def frugal (memoize expensive))

(deftest frugal-test
  (let [current (System/currentTimeMillis)
        res (frugal 44)
        firstcall (System/currentTimeMillis)
        res2 (frugal 44)
        secondcall (System/currentTimeMillis)
        diff1 (- firstcall current)
        diff2 (- secondcall firstcall)]
    (is (and (> diff1 diff2) (< diff2 4000)))))

