console.log("theme script(OLED)");

//__theme toggle script-OLED____________________________________________________________

    //current theme 
       let defaultTheme = "light";
       let currentTheme=themeGetFromLocal();

       //theme vars ->targets ->class for html tag directly
       let lightTheme="light";
       let darkTheme="dark";
       let oledTheme="oled";

       //body vars ->targets ->body inside html
       let bodyNormal="dark:bg-gray-950";
       let bodyOled="dark:bg-black";

       //element vars ->targets ->elements inside body
       let elementNormal="bg-fuchsia-300";
       let elementDark="dark:bg-gray-900";
       let elementOled="dark:bg-black";
       let elementHoverNormal="hover:bg-fuchsia-400";
       let elementHoverDark="dark:hover:bg-gray-800";
       let elementHoverOled="dark:hover:bg-gray-900";
       

       //local vars
       let add="add";
       let remove="remove";

       //tag vars ->targets ->tags inside html doc
       let htmlTag="html";
       let bodyTag="body";
       let divTag="div";
       let aTag="a";
       let buttonTag="button";

       //tag array
       const tags = [
        aTag, 
        buttonTag
    ];

      //tag array for hover effect
      const hoverTags = [
        aTag,
        buttonTag
      ];

       //elementByNames
       const names = [
        "card"
    ];

    //__________________________________________________________________

    //themeOpration(className, oprationAddOrRemove, targetedTag);
    //themeSwap(oldTheme, newTheme, targetedTag, nextThemeNameForbuttonName);

    //eleClassSwap(removingClass, addingClass, targetedTags, targetedNames)

 //initial run___________________________________________________________
   
            //check current theme
            if(currentTheme == darkTheme ){

              //set dark theme 
              themeOpration(
                darkTheme, 
                add, 
                htmlTag
            );
              themeSwap(
                bodyOled, 
                bodyNormal, 
                bodyTag, 
                oledTheme
            );
            eleAddClass(elementDark, tags, names);
            eleAddClass(elementHoverDark, hoverTags, null);
        
              
            }else if(currentTheme == oledTheme) {

                //set oled theme 
                themeSwap(
                     bodyNormal,
                     bodyOled, 
                     bodyTag, 
                     lightTheme
                    );
                    
                    eleAddClass(elementOled, tags, names);
                    eleAddClass(elementHoverOled, hoverTags, null);

            }else{

                //set light theme
                themeSwap(darkTheme,
                     lightTheme,
                     htmlTag,
                     darkTheme
                    );

                    eleAddClass(elementNormal, tags, names);
                    eleAddClass(elementHoverNormal, hoverTags, null);


                    
                
            }
            
//_______________________________________________________________________



//Dynamic Switch_________________________________________________________
       const changeDetectButton = 
       document.querySelector("#theme_toggle_ele");
       
       //Dynamic Theme Changer 
       changeDetectButton.addEventListener(
        "click", 
        (event) => {

        cleanLocal();

        if(currentTheme == darkTheme){

            //set oled dynamic
            themeSwap(
                 bodyNormal,
                 bodyOled, 
                 bodyTag, 
                 lightTheme
                );
                eleRemoveClass(elementDark, tags, names);
                eleAddClass(elementOled, tags, names);


            //save theme
            saveTheme(oledTheme);


        } else if(currentTheme == oledTheme) {

            //set light dynamic
            themeSwap(
                darkTheme, 
                lightTheme, 
                htmlTag, 
                darkTheme
            );

            eleAddClass(elementNormal, tags, names);

            //save theme
            saveTheme(lightTheme);

        } else {

            //set dark dynamic - body
            themeSwap(
                bodyOled, 
                bodyNormal, 
                bodyTag, 
                null
            );

            //set dark dynamic - class
            themeSwap(
                lightTheme, 
                darkTheme, 
                htmlTag , 
                oledTheme
            );
              
            eleAddClass(elementDark, tags, names);
            //save theme
            saveTheme(darkTheme);
        }
        
       });
//_______________________________________________________________________________        



//Theme functions_______________________________________________________________
       //oprations on theme
       function themeOpration(theme, opration, element) {
        if(opration == add){
            document.querySelector(element).classList.add(theme);
       }
       if(opration == remove) {
            document.querySelector(element).classList.remove(theme);
        }
    }

       //theme swaper________________________________________________________
       function themeSwap(oldTheme, newTheme, element, nextTheme) {
        //add opration
        themeOpration(oldTheme, remove, element);
        //remove opration
        themeOpration(newTheme, add, element);

        if(nextTheme != null) {
            pointToNextTheme(nextTheme);
        }
    }

       //theme saver_________________________________________________________
       function saveTheme(theme){
        themeSetToLocal(theme);
        currentTheme = theme;
    }

       //button name setter________________________________________________
      function pointToNextTheme(theme){
        document.getElementById("theme_toggle").innerHTML =`${theme}`;
    }

        
//__________________________________________________________________________

//element functions________________________________________________________
       //swap element class in bulk
      function eleRemoveClass(bgClass, hoverClass, targetedTags, targetedNames) {
        if(targetedTags != null) {    
        targetedTags.forEach(tag => {
             const elements = Array.from(document.querySelectorAll(tag));
                   elements.forEach((e) => {
                    e.classList.remove(bgClass);
                    
                });
            });
        }
            if(targetedNames != null) {  
                targetedNames.forEach((e) => {
                    const name = document.getElementsByName(e);
                    name.forEach((n) => {
                        n.classList.remove(bgClass);
                    })
                   
                });
            }   
        }
    
        function eleAddClass(bgClass, hoverClass, targetedTags, targetedNames) {
            if(targetedTags != null) { 
            targetedTags.forEach(tag => {
                const elements = Array.from(document.querySelectorAll(tag));
                      elements.forEach((e) => {
                       e.classList.add(bgClass);
                   });
               });
            }
   
               if(targetedNames != null) {   
                   targetedNames.forEach((e) => {
                       const name = document.getElementsByName(e);
                       name.forEach((n) => {
                           n.classList.add(bgClass);
                       })
                      
                   });
                }
        }


      //___________________________________________________________
    
        
//local storage__________________________________________________________________________       

        //Save Theme To LocalStorage____________________________________________
        function themeSetToLocal(theme) {
            localStorage.setItem("theme", theme);
        }
        
        //Get Theme From LocalStorage__________________________________________
        function themeGetFromLocal() {
            let theme = localStorage.getItem("theme");
            return theme != null ? theme : defaultTheme ;
        }

        //clean LocalStorage___________________________________________________
        function cleanLocal(){
            localStorage.clear();
        }
//______________________________________________________________________________________
