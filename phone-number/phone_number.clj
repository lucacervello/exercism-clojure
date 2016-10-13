(ns phone-number)

(defn number [number]
  (let [number (apply str (re-seq #"\d" number))]
    (if (> (count number) 10)
      (if (= \1 (first number))
        (apply str (rest number))
        "0000000000")
      (if (< (count number) 10)
        "0000000000"
        number))))

(defn area-code [phone-number]
  (apply str (take 3 (number phone-number))))

(defn pretty-print [phone-number]
  (let [phone (number phone-number)]
    (str "(" (subs phone 0 3) ") " (subs phone 3 6) "-" (subs phone 6))))
