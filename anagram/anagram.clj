(ns anagram)

(defn anagrams-for [str seq]
  (let [clean-str (clojure.string/lower-case str)
        str-frequencies (frequencies clean-str)
        anagram? (fn [seq-str]
                   (and
                    (= str-frequencies (frequencies (clojure.string/lower-case seq-str)))
                    (not (= clean-str seq-str))))]
    (filter anagram? seq)))
