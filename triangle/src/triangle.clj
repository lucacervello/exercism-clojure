(ns triangle)

(helper = [2 2 2])

(defn- illogical? [[x y z]]
  (or (>= z (+ x y))
      (>= x (+ z y))
      (>= y (+ x z))))

(defn- isosceles? [[x y z]]
  (or (= x y)
      (= y z)
      (= x z)))

(defn- scalene? [[x y z]]
  (or (not= x y)
      (not= y z)
      (not= x z)))

(defn- equilateral? [[x y z]]
  (= x y z))

(defn type [x y z]
  (let [triangle [x y z]]
    (cond
      (illogical? triangle) :illogical
      (equilateral? triangle) :equilateral
      (isosceles? triangle) :isosceles
      (scalene? triangle) :scalene)))
