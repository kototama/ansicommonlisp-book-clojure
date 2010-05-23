(use 'clojure.test)

;; like in CL but thread-safe!

(let [maxsofar (atom nil)]
  (defn max-so-far [n]
    (if (or (nil? @maxsofar) (> n @maxsofar))
      (swap! maxsofar (constantly n))
      @maxsofar)))


(deftest max-so-far-test
  (is (= 10 (max-so-far 10)))
  (is (= 42 (max-so-far 42)))
  (is (= 42 (max-so-far 30))))
