(this["webpackJsonpreact-auth"]=this["webpackJsonpreact-auth"]||[]).push([[0],{54:function(e,t,c){},61:function(e,t,c){"use strict";c.r(t);var n=c(1),r=c.n(n),a=c(26),s=c.n(a),o=c(25),i=(c(53),c(64)),l=c(65),u=c(47),j=c(11),b=(c(54),c(0)),d=c.n(b),p=c(3),h=c(63),O=c(12),m=c(24),x=c(42),f=Object(x.a)({apiKey:"AIzaSyDCeoFjR6jwBifi2JHNCOfwMcbzysp6jYs",authDomain:"gcchecker.firebaseapp.com",projectId:"gcchecker",storageBucket:"gcchecker.appspot.com",messagingSenderId:"812183776305",appId:"1:812183776305:web:3908ba6637d128f9d03910"}),v=Object(m.c)(f),g=c(4),y=Object(n.createContext)();function S(e){var t=e.children,c=Object(n.useState)({}),r=Object(O.a)(c,2),a=r[0],s=r[1];return Object(n.useEffect)((function(){var e=Object(m.d)(v,(function(e){console.log("Auth",e),s(e)}));return function(){e()}}),[]),Object(g.jsx)(y.Provider,{value:{user:a,logIn:function(e,t){return Object(m.e)(v,e,t)},signUp:function(e,t){return Object(m.b)(v,e,t)},logOut:function(){return Object(m.g)(v)},googleSignIn:function(){var e=new m.a;return Object(m.f)(v,e)}},children:t})}function k(){return Object(n.useContext)(y)}var w=function(){var e=k(),t=e.logOut,c=e.user,n=Object(j.g)(),r=function(){var e=Object(p.a)(d.a.mark((function e(){return d.a.wrap((function(e){for(;;)switch(e.prev=e.next){case 0:return e.prev=0,e.next=3,t();case 3:n("/"),e.next=9;break;case 6:e.prev=6,e.t0=e.catch(0),console.log(e.t0.message);case 9:case"end":return e.stop()}}),e,null,[[0,6]])})));return function(){return e.apply(this,arguments)}}();return Object(g.jsxs)(g.Fragment,{children:[Object(g.jsxs)("div",{className:"p-4 box mt-3 text-center",children:["Bienvenue sur votre espace :  ",Object(g.jsx)("br",{}),c&&c.email]}),Object(g.jsx)("a",{href:"http://localhost:8080/banque/java.php",children:"Acc\xe9der a l'application "}),Object(g.jsx)("div",{className:"d-grid gap-2",children:Object(g.jsx)(h.a,{variant:"primary",onClick:r,children:"Log out"})})]})},C=c(66),I=c(67),N=c(43),E=c.n(N),L=function(){var e=Object(n.useState)(""),t=Object(O.a)(e,2),c=t[0],r=t[1],a=Object(n.useState)(""),s=Object(O.a)(a,2),i=s[0],l=s[1],u=Object(n.useState)(""),b=Object(O.a)(u,2),m=b[0],x=b[1],f=k(),v=f.logIn,y=f.googleSignIn,S=Object(j.g)(),w=function(){var e=Object(p.a)(d.a.mark((function e(t){return d.a.wrap((function(e){for(;;)switch(e.prev=e.next){case 0:return t.preventDefault(),x(""),e.prev=2,e.next=5,v(c,i);case 5:S("/home"),e.next=11;break;case 8:e.prev=8,e.t0=e.catch(2),x(e.t0.message);case 11:case"end":return e.stop()}}),e,null,[[2,8]])})));return function(t){return e.apply(this,arguments)}}(),N=function(){var e=Object(p.a)(d.a.mark((function e(t){return d.a.wrap((function(e){for(;;)switch(e.prev=e.next){case 0:return t.preventDefault(),e.prev=1,e.next=4,y();case 4:S("/home"),e.next=10;break;case 7:e.prev=7,e.t0=e.catch(1),console.log(e.t0.message);case 10:case"end":return e.stop()}}),e,null,[[1,7]])})));return function(t){return e.apply(this,arguments)}}();return Object(g.jsxs)(g.Fragment,{children:[Object(g.jsxs)("div",{className:"p-4 box",children:[Object(g.jsx)("h2",{className:"mb-3",children:" GC Checker "}),m&&Object(g.jsx)(C.a,{variant:"danger",children:m}),Object(g.jsxs)(I.a,{onSubmit:w,children:[Object(g.jsx)(I.a.Group,{className:"mb-3",controlId:"formBasicEmail",children:Object(g.jsx)(I.a.Control,{type:"email",placeholder:"Email address",onChange:function(e){return r(e.target.value)}})}),Object(g.jsx)(I.a.Group,{className:"mb-3",controlId:"formBasicPassword",children:Object(g.jsx)(I.a.Control,{type:"password",placeholder:"Password",onChange:function(e){return l(e.target.value)}})}),Object(g.jsx)("div",{className:"d-grid gap-2",children:Object(g.jsx)(h.a,{variant:"primary",type:"Submit",children:"Log In"})})]}),Object(g.jsx)("hr",{}),Object(g.jsx)("div",{children:Object(g.jsx)(E.a,{className:"g-btn",type:"dark",onClick:N})})]}),Object(g.jsxs)("div",{className:"p-4 box mt-3 text-center",children:["Don't have an account? ",Object(g.jsx)(o.b,{to:"/signup",children:"Sign up"})]})]})},A=function(){var e=Object(n.useState)(""),t=Object(O.a)(e,2),c=t[0],r=t[1],a=Object(n.useState)(""),s=Object(O.a)(a,2),i=s[0],l=s[1],u=Object(n.useState)(""),b=Object(O.a)(u,2),m=b[0],x=b[1],f=k().signUp,v=Object(j.g)(),y=function(){var e=Object(p.a)(d.a.mark((function e(t){return d.a.wrap((function(e){for(;;)switch(e.prev=e.next){case 0:return t.preventDefault(),l(""),e.prev=2,e.next=5,f(c,m);case 5:v("/"),e.next=11;break;case 8:e.prev=8,e.t0=e.catch(2),l(e.t0.message);case 11:case"end":return e.stop()}}),e,null,[[2,8]])})));return function(t){return e.apply(this,arguments)}}();return Object(g.jsxs)(g.Fragment,{children:[Object(g.jsxs)("div",{className:"p-4 box",children:[Object(g.jsx)("h2",{className:"mb-3",children:"Inscription GC Checker"}),i&&Object(g.jsx)(C.a,{variant:"danger",children:i}),Object(g.jsxs)(I.a,{onSubmit:y,children:[Object(g.jsx)(I.a.Group,{className:"mb-3",controlId:"formBasicEmail",children:Object(g.jsx)(I.a.Control,{type:"email",placeholder:"Email address",onChange:function(e){return r(e.target.value)}})}),Object(g.jsx)(I.a.Group,{className:"mb-3",controlId:"formBasicPassword",children:Object(g.jsx)(I.a.Control,{type:"password",placeholder:"Password",onChange:function(e){return x(e.target.value)}})}),Object(g.jsx)("div",{className:"d-grid gap-2",children:Object(g.jsx)(h.a,{variant:"primary",type:"Submit",children:"Sign up"})})]})]}),Object(g.jsxs)("div",{className:"p-4 box mt-3 text-center",children:["Already have an account? ",Object(g.jsx)(o.b,{to:"/",children:"Log In"})]})]})},B=function(e){var t=e.children,c=k().user;return console.log("Check user in Private: ",c),c?t:Object(g.jsx)(j.a,{to:"/"})};var q=document.querySelectorAll(".btn-prev"),D=document.querySelectorAll(".btn-next"),G=document.getElementById("progress"),P=document.querySelectorAll(".form-step"),F=document.querySelectorAll(".progress-step"),J=0;function z(){P.forEach((function(e){e.classList.contains("form-step-active")&&e.classList.remove("form-step-active")})),P[J].classList.add("form-step-active")}function M(){F.forEach((function(e,t){t<J+1?e.classList.add("progress-step-active"):e.classList.remove("progress-step-active")}));var e=document.querySelectorAll(".progress-step-active");G.style.width=(e.length-1)/(F.length-1)*100+"%"}D.forEach((function(e){e.addEventListener("click",(function(){J++,z(),M()}))})),q.forEach((function(e){e.addEventListener("click",(function(){J--,z(),M()}))}));var U=function(){return Object(g.jsx)(i.a,{style:{width:"400px"},children:Object(g.jsx)(l.a,{children:Object(g.jsx)(u.a,{children:Object(g.jsx)(S,{children:Object(g.jsxs)(j.d,{children:[Object(g.jsx)(j.b,{path:"/home",element:Object(g.jsx)(B,{children:Object(g.jsx)(w,{})})}),Object(g.jsx)(j.b,{path:"/",element:Object(g.jsx)(L,{})}),Object(g.jsx)(j.b,{path:"/signup",element:Object(g.jsx)(A,{})})]})})})})})};s.a.render(Object(g.jsx)(r.a.StrictMode,{children:Object(g.jsx)(o.a,{children:Object(g.jsx)(U,{})})}),document.getElementById("root"))}},[[61,1,2]]]);
//# sourceMappingURL=main.6ea5da90.chunk.js.map