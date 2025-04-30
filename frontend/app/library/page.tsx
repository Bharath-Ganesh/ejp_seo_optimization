import Head from 'next/head'
import { useState } from 'react'
import useSWR from 'swr'
import Link from 'next/link'

const fetcher = (url: string) => fetch(url).then(res => res.json())

export default function LibraryPage() {
  const [q, setQ] = useState('')
  const { data: guides } = useSWR(`/api/guides?q=${q}`, fetcher)

  return (
    <>
      <Head>
        <title>Guide Library</title>
      </Head>
      <input value={q} onChange={e => setQ(e.target.value)} placeholder="Search guides…" />
      <ul>
        {guides?.map(g => (
          <li key={g.id}>
            <Link href={`/library/${g.slug}`}>{g.title}</Link>
          </li>
        ))}
      </ul>
    </>
  )
}
