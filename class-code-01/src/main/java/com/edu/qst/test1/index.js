const user = {
    name:"Tom",
    eat: () => {
        return "eat"
    },
};


console.log(user);
user.name ="shabi"
console.log(user);

function ref(){

}


const age = ref(12);

age.value = 13;