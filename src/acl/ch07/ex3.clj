(ns acl.ch07.ex3
  (:use clojure.test clojure.contrib.duck-streams
        [clojure.contrib.str-utils2 :only (split)]))

(defn filecopy-nocomment [infilename outfilename]
  (write-lines outfilename (map (fn [l]
                                  (let [bits (split l #"%")]
                                    (if (nil? bits)
                                      ""
                                      (first bits))))
                                (read-lines infilename))))

;; (filecopy-nocomment "test3.txt" "test3_out.txt")
