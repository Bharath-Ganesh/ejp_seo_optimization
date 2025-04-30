'use client'
import { signIn } from 'next-auth/react'
import { useRouter } from 'next/navigation'
import { useState } from 'react'

export default function LoginPage() {
  const [user, setUser] = useState({ username: '', password: '' })
  const router = useRouter()

  const handleSubmit = async (e: React.FormEvent) => {
    e.preventDefault()
    const res = await signIn('credentials', {
      username: user.username,
      password: user.password,
      redirect: false
    })
    if (res?.ok) router.push('/library')
  }

  return (
    <form onSubmit={handleSubmit}>
      <input type="text" placeholder="Username" onChange={e => setUser(u => ({ ...u, username: e.target.value }))} />
      <input type="password" placeholder="Password" onChange={e => setUser(u => ({ ...u, password: e.target.value }))} />
      <button type="submit">Login</button>
    </form>
  )
}
