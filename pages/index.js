import Head from 'next/head';
import Card from './Card';
import UserData from './UserData';

const Fcard = (val) => (
  <Card 
  key = {val.id}
  imgsrc = {val.imgsrc}
  Name = {val.Name}
  Description = {val.Description}
  github = {val.github} 
  />
);

export default function Home() {
  return (
    <>
      <Head> 
        <title> List of Contributors </title>
        <link rel="icon" href="favicon.png" />
      </Head>
      <div>
        <h1 className = "Heading"> 
        List of Contributors </h1>
        {UserData.map(Fcard)}
    </div>
    </>
  )
}
