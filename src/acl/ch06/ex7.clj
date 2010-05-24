(ns acl.ch06.ex7)

(let [lastval (atom nil)]
  (defn greater-than-last? [n]
    (let [prev @lastval]
      (swap! lastval (constantly n))
      (if (not (nil? prev))
        (> n prev)
        false))))
