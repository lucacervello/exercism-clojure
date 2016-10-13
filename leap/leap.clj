(ns leap)

(defn leap-year? [year]
  (if (= (rem year 4) 0)
    (if (= (rem year 100) 0)
      (if (= (rem year 400) 0)
        true
        )
      true)))
