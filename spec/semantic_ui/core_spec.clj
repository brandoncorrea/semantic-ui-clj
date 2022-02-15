(ns semantic-ui.core-spec
  (:require [speclj.core :refer :all]
            [semantic-ui.core :refer :all]
            [clojure.string :as s]))

(defn button-class-should= [expected options]
  (should= {:class expected} (-> options button second)))

(describe "Semantic UI Hiccup"
  (context "button"
    (it "results in a vector"
      (should (vector? (button))))
    (it "uses the button tag"
      (should= :button (first (button))))
    (it "contains button and ui classes"
      (should= "ui button" (:class (second (button)))))
    (it "contains button text"
      (let [[_ options text] (button "Some Text")]
        (should= {:class "ui button"} options)
        (should= "Some Text" text)))
    (it "ignores blank text"
      (let [[_ _ text] (button " \r\t\n")]
        (should-be-nil text)))
    (it "includes active class when active is truthy"
      (button-class-should= "ui active button" {:active true}))
    (it "excludes active class when active is falsy"
      (button-class-should= "ui button" {:active false}))
    (it "includes default animated class"
      (button-class-should= "ui animated button" {:animated true}))
    (it "includes vertical animated class"
      (button-class-should= "ui vertical animated button" {:animated :vertical}))
    (it "includes fade animated class"
      (button-class-should= "ui fade animated button" {:animated :fade}))
    (it "'as' option selects element type to render as"
      (should= :p (first (button {:as :p}))))
    (it "'as' option casts strings to keywords"
      (should= :div (first (button {:as "div"}))))
    (it "'as' option casts symbols to keywords"
      (should= :h1 (first (button {:as 'h1}))))
    (it "accepts function in 'as' option"
      (should= identity (first (button {:as identity}))))
    (it "attaches button to 'top'"
      (button-class-should= "ui top attached button" {:attached :top}))
    (it "attaches button to 'left'"
      (button-class-should= "ui left attached button" {:attached :left}))
    (it "attaches button to 'bottom'"
      (button-class-should= "ui bottom attached button" {:attached :bottom}))
    (it "attaches button to 'right'"
      (button-class-should= "ui right attached button" {:attached :right}))
    (it "creates a 'basic' button"
      (button-class-should= "ui basic button" {:basic true}))
    (it "can be circular"
      (button-class-should= "ui circular button" {:circular true}))
    (it "class-name options are appended with class-name"
      (button-class-should= "ui button special-class" {:class-name "special-class"}))
    (it "class-name is trimmed"
      (button-class-should= "ui button some-class" {:class-name "  some-class  "}))
    (for [color [:red :orange :yellow :olive :green :teal
                 :blue :violet :purple :brown :grey :black
                 :facebook :google-plus :instagram :linkedin
                 :twitter :vk :youtube]]
      (it (str "applies color: " color)
        (let [expected-color (s/replace (subs (str color) 1) #"-" " ")]
          (button-class-should= (str "ui " expected-color " button") {:color color}))))
    (it "can be compact"
      (button-class-should= "ui compact button" {:compact true}))
    (it "can replace text variable with content"
      (let [[_ _ text] (button {:content "Some Button Text"})]
        (should= "Some Button Text" text)))
    (it "can be disabled"
      (button-class-should= "ui disabled button" {:disabled true}))
    (it "can be floated left"
      (button-class-should= "ui left floated button" {:floated :left}))
    (it "can be floated right"
      (button-class-should= "ui right floated button" {:floated :right}))
    (it "can be fluid"
      (button-class-should= "ui fluid button" {:fluid true}))
    (it "can be inverted without a color"
      (button-class-should= "ui inverted button" {:inverted true}))
    (it "can be inverted with a color"
      (button-class-should= "ui red inverted button" {:inverted true :color :red}))
    (it "displays a loading indicator"
      (button-class-should= "ui loading button" {:loading true}))
    (it "hints toward a negative consequence"
      (button-class-should= "ui negative button" {:negative true}))
    (it "applies an on-click function"
      (let [[_ options _] (button {:on-click inc})]
        (should= inc (:on-click options))))
    (it "hints toward a positive consequence"
      (button-class-should= "ui positive button" {:positive true}))
    (it "can be formatted with a primary emphasis"
      (button-class-should= "ui primary button" {:primary true}))
    (it "can be formatted with a secondary emphasis"
      (button-class-should= "ui secondary button" {:secondary true}))
    (it "can be given a role"
      (let [[_ options] (button {:role "some-role"})]
        (should= {:class "ui button" :role "some-role"} options)))
    (for [size [:mini :tiny :small :medium :large :big :huge :massive]]
      (it (str "can have a size of " size)
        (button-class-should=
          (str "ui " (subs (str size) 1) " button")
          {:size size})))
    (it "applies toggled off class"
      (let [[_ options] (button {:toggle true})]
        (should= {:class "ui toggle button" :aria-pressed false} options)))
    (it "applies toggled on class"
      (let [[_ options] (button {:toggle true :active true})]
        (should= {:class "ui active toggle button" :aria-pressed true} options)))
    (for [type [:button :submit :reset]]
      (it (str "accepts an HTML button type of " type)
        (let [[_ options] (button {:type type})]
          (should= {:class "ui button" :type (subs (str type) 1)} options)))))

  (context "container"
    (it "results in a vector"
      (should (vector? (container))))
    (it "renders as div with class ui container"
      (let [[tag options _] (container)]
        (should= :div tag)
        (should= {:class "ui container"} options)))
    (it "renders as :span"
      (should= :span (first (container {:as :span}))))
    (it "renders as \"p\""
      (should= :p (first (container {:as "p"}))))
    (it "can render as a function"
      (should= identity (first (container {:as identity}))))
    (it "can be fluid"
      (should= {:class "ui fluid container"} (second (container {:fluid true}))))
    (it "can be a text container"
      (should= {:class "ui text container"} (second (container {:text true}))))
    (for [alignment [:left :center :right]]
      (it (str "can be aligned " alignment)
        (should= {:class (str "ui " (subs (str alignment) 1) " aligned container")}
                 (second (container {:text-align alignment})))))
    (it "can justify text content"
      (should= {:class "ui justified container"} (second (container {:text-align :justified}))))
    (it "can have additional classes using class-name"
      (should= {:class "ui container and-another class"}
               (second (container {:class-name "  and-another class  "})))))

  (context "flag"
    (it "renders as vector"
      (should (vector? (flag {:name "us"}))))
    (it "renders as an 'i' element"
      (should= :i (first (flag {:name "us"}))))
    (it "renders 'as' a :div"
      (should= :div (first (flag {:as :div :name "us"}))))
    (it "adds country name to beginning of class list"
      (should= "france flag" (:class (second (flag {:name "france"}))))
      (should= "us flag" (:class (second (flag {:name "us"})))))
    (it "appends class list with additional classes"
      (let [[_ options] (flag {:name "ad" :class-list "  something-else  "})]
        (should= "ad flag something-else" (:class options))))))
