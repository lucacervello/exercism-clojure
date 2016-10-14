(ns bob)

(defn yelling? [string]
  (>= (count (filter #(Character/isUpperCase %) string))
      (count (filter #(Character/isLetter %) string))
      1))

(defn question? [string]
  (= \? (last string)))

(defn response-for [arg]
  (cond
    (clojure.string/blank? arg) "Fine. Be that way!"
    (yelling?  arg) "Whoa, chill out!"
    (question? arg) "Sure."
    :else "Whatever."))
