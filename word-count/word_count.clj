(ns word-count)

(defn word-count [str]
  (frequencies (re-seq #"\w+"  (clojure.string/lower-case str))))
