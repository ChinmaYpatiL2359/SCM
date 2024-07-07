console.log("theme script(OLED)");

//__theme toggle script-NORMAL____________________________________________________________

    //current theme 
       let defaultTheme = "light";
       let currentTheme=themeGetFromLocal();

       //theme vars ->targets ->class
       let lightTheme="light";
       let darkTheme="dark";


       //local vars
       let add="add";
       let remove="remove";
       let htmlTag="html";

    //__________________________________________________________________

 //initial run___________________________________________________________
   
            //check current theme
            if(currentTheme == darkTheme ){

              //set dark theme 
              themeSwap(lightTheme, darkTheme, htmlTag, lightTheme);
              
            }else{

                //set light theme
                themeSwap(darkTheme,
                     lightTheme,
                     htmlTag,
                     darkTheme
                    );
                
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

            //set light dynamic
            themeSwap(
                darkTheme, 
                lightTheme, 
                htmlTag, 
                darkTheme
            );

            //save theme
            saveTheme(lightTheme);

        } else {

            //set dark dynamic - class
            themeSwap(
                lightTheme, 
                darkTheme, 
                htmlTag , 
                lightTheme
            );

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
        themeOpration(oldTheme,remove,element);
        //remove opration
        themeOpration(newTheme,add,element);
        
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
    
    
        
//local storage__________________________________________________________________________       

        //Save Theme To LocalStorage____________________________________________
        function themeSetToLocal(theme) {
            localStorage.setItem("theme",theme);
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
