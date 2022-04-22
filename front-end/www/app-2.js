var firebaseConfig = {
  apiKey: "AIzaSyDCeoFjR6jwBifi2JHNCOfwMcbzysp6jYs",
  authDomain: "gcchecker.firebaseapp.com",
  projectId: "gcchecker",
  storageBucket: "gcchecker.appspot.com",
  messagingSenderId: "812183776305",
};

firebase.initializeApp(firebaseConfig);

const auth = firebase.auth()

 console.log(auth)


//this for logOut
let signOutButton = document.getElementById("signout")
signOutButton.addEventListener("click", (e) => {
  //Prevent Default Form Submission Behavior
  e.preventDefault()
  console.log("clicked")
  
  auth.signOut()
  alert("Signed Out")
  window.location = "log-in.html";
})