(ns cljs-leva.app
  (:require

;;    [reagent.core :as reagent]
;;    [reagent.dom :as d]
   [uix.core :as uix :refer [defui $]]
   [uix.dom]
   [leva.uix :as leva]
   ["@pixi/react" :as pixi-react]
   ["pixi.js" :as pixi]))

;; (defonce hello 1)

;; (defn leva-panel [!state-atom]
;;   [leva/SubPanel {:titleBar {:drag true}}
;;    [leva/Controls {:atom !state-atom}]])

;; (def selected-id (reagent/atom ""))

;; (defn select [new-id]
;;   (reset! selected-id new-id))

;; (defn selected [id]
;;   (= @selected-id id))

;; (defn toggle-leva-on-click [initial-styles]
;;   (reagent/with-let [!styles (reagent/atom initial-styles)
;;                      id (str (random-uuid))]
;;     [:div
;;      [:div {:style @!styles :on-click #(select id)}]
;;      (when (selected id)
;;        (leva-panel !styles))]))

(defui sprite []
  ($ pixi-react/Stage
     ($ pixi-react/Sprite {:x 400 :y 270 :image "https://pixijs.io/pixi-react/img/bunny.png"})))

(defonce my-atom (atom {:height "100px"}))


(defui leva-demo []
  ($ :<>
     ($ leva/hello-world)
     ($ leva/SubPanel {:opts {:titleBar {:drag true}}} ($ leva/Controls {:opts {:atom my-atom}})))

  ;;  [toggle-leva-on-click {:background-color "orange"
  ;;                         :height "100px"
  ;;                         :width "100px"
  ;;                         :border-color "black"
  ;;                         :border-style "solid"
  ;;                         :border-width "1px"}]

  ;;  [toggle-leva-on-click {:background-color "green"
  ;;                         :height "100px"
  ;;                         :width "100px"
  ;;                         :border-radius "30px"}]
  )


;; (defui button [{:keys [on-click children]}]
;;   ($ :button.btn {:on-click on-click}
;;      children))


;; ;; (defui leva-panel [!state-atom])

;; (defui app []
;;   (let [[state set-state!] (uix.core/use-state 0)]
;;     ($ :<>
;;     ;;    (reagent/as-element [leva-demo])
;;        )))

(defui app []
  ($ :<> ($ leva-demo)))

(defonce root
  (uix.dom/create-root (js/document.getElementById "root")))

(uix.dom/render-root ($ app) root)

;; (defonce root
;;   (uix.dom/create-root (js/document.getElementById "root")))

;; (uix.dom/render-root ($ app) root)

;; (defn ^:export init! []
;;   (mount-root))
