(ns acl.ch07.ex3
  (:use clojure.test
        [clojure.contrib.duck-streams :only (write-lines
                                             read-lines)])
  (:require [clojure.string :as str]))

(defn filecopy-nocomment [infilename outfilename]
  (write-lines outfilename (map (fn [l]
                                  (let [bits (str/split l #"%")]
                                    (if (nil? bits)
                                      ""
                                      (first bits))))
                                (read-lines infilename))))

;; (filecopy-nocomment "test3.txt" "test3_out.txt")
