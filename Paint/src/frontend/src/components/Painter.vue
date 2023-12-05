<template>
  <div>
    <v-stage ref="stage" :config="configKonva">
      <v-layer ref="layer">
        <v-circle
            v-for="item in items"
            :config="item"
            @dragstart="handleDragstart"
            @dragend="handleDragend"
        ></v-circle>
      </v-layer>
    </v-stage>
  </div>
  <button @click="generateItems()">circle</button>
</template>

<script>
import Konva from "konva";
const width = window.innerWidth;
const height = window.innerHeight;
export default {
  data() {
    return {
      items: [],
      dragItemId: null,
      configKonva: {
        width: width,
        height: height,
      },
    };
  },
  methods: {
    generateItems() {
      this.items.push({
        x: Math.random() * width,
        y: Math.random() * height,
        radius: 50,
        fill: Konva.Util.getRandomColor(),
        draggable: true,
      });
      return this.items;
    },
    handleDragstart(e) {
      // save drag element:
      this.dragItemId = e.target.id();
      // move current element to the top, by rearranging the items array:
      const item = this.items.find((i) => i.id === this.dragItemId);
      const index = this.items.indexOf(item);
      this.items.splice(index, 1);
      this.items.push(item);
    },
    handleDragend(e) {
      this.dragItemId = null;
    },
  },
  mounted() {
  },
};
</script>

<style>
body {
  margin: 0;
  padding: 0;
}
</style>
