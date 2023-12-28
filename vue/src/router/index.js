import { createRouter, createWebHistory } from "vue-router";
import Layout from "../layout/Layout.vue";
import { getCookie } from "@/utils/cookie";

const routes = [
    {
        path: '/',
        name: 'Layout',
        component: Layout,
        redirect: "/login",
        children: [
            {
                path: 'home',
                name: 'Home',
                component: () => import("@/views/Home"),
                meta: { title: 'Home' }
            },
        ]
    },
    {
        path: '/login',
        name: 'Login',
        component: () => import("@/views/Login"),
        meta: { title: 'Login' }
    },
]

const router = createRouter({
    history: createWebHistory(process.env.BASE_URL),
    routes
})

router.beforeEach((to, from, next) => {
    window.document.title = to.meta.title
    if(to.name !== "Login" && !getCookie("user")) {
        next({ name: "Login" })
    } else { next() }
})

export default router