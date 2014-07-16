(ns tron.bots
  (:require [tron.core :as tron]))

; Implement a strategy similar to Buzz!!
(defn buzz
  "To infinity and beyond!"
  [look {[x y] :pos}]
  {:pos [(inc x) y]})

(defn south-walker
  [look {[x y] :pos}]
  {:pos [x (inc y)]})

(defn is-empty? [look pos]
  ;(println (look pos))
  (not (look pos)))

(defn go-west [[x y]]
  [(dec x) y])

(defn go-east [[x y]]
  [(inc x) y])

(defn go-north [[x y]]
  [x (dec y)])

(defn go-south [[x y]]
  [x (inc y)])

(defn turn-turn [look [x y :as pos]]
  (cond
   (is-empty? look (go-east pos)) (go-east pos)
   (is-empty? look (go-west pos)) (go-west pos)
   (is-empty? look (go-north pos)) (go-north pos)
   (is-empty? look (go-south pos)) (go-south pos)
   :true [(inc x) (inc y)]))

(defn turner [look {[x y] :pos}]
  {:pos (turn-turn look [x y])})



; Choose a TEAM colour
(def red 1)
(def orange 25)
(def yellow 50)
(def green 100)
(def blue 150)
(def purple 200)

; Start the battle
;(tron/spawn-biker buzz red)

; Stop the battle
;(tron/stop!)

; Reset the arena
;(tron/blank-arena)


(defn start []
  (do
    (tron/stop!)
    (tron/blank-arena)
    (tron/spawn-biker buzz red)
    (tron/spawn-biker south-walker green)
    (tron/spawn-biker turner orange)

    )
  )

(defn -main []
  (start))
