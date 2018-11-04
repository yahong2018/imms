<template>
  <div>
    <router-link to='newContract'>
      <h1>{{msg}}</h1>
    </router-link>
    <router-link to='myLayout'>
      <h1>Layout test</h1>
    </router-link>
  </div>
</template>
<script>
export default {
  name: 'HelloWorld',
  data() {
    return {
      msg: 'New Contract'
    };
  }
};
</script>

<!-- Add 'scoped' attribute to limit CSS to this component only -->
<style scoped>
h1 {
  font-weight: normal;
}
a {
  color: #42b983;
}
</style>
