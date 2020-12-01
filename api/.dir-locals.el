;;; Directory Local Variables
;;; For more information see (info "(emacs) Directory Variables")

((clojure-mode
   (cider-clojure-cli-global-options . "-A:dev")
   (cider-shadow-cljs-global-options . "-A:dev")
   (cider-preferred-build-tool . "shadow-cljs")
   (cider-offer-to-open-cljs-app-in-browser . nil)
   (cider-default-cljs-repl . shadow)
   (cider-shadow-default-options . "api")))
