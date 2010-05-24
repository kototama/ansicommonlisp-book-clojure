(ns acl.ch06.ex6)

;; like in Common Lisp but thread-safe!

(let [maxsofar (atom nil)]
  (defn max-so-far [n]
    (if (or (nil? @maxsofar) (> n @maxsofar))
      (swap! maxsofar (constantly n))
      @maxsofar)))
