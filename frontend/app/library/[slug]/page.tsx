import { GetServerSideProps } from 'next'
import Head from 'next/head'

export default function Detail({ guide }: any) {
  return (
    <>
      <Head>
        <title>{guide.title}</title>
      </Head>
      <h1>{guide.title}</h1>
      <p>{guide.description}</p>
      <a href={guide.pdfUrl} target="_blank">Download PDF</a>
    </>
  )
}

export const getServerSideProps: GetServerSideProps = async ({ params }) => {
  const guide = await fetch(`http://localhost:8002/resources/${params?.slug}`).then(r => r.json())
  return { props: { guide } }
}
