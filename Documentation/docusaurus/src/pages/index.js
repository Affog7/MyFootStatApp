import React from 'react';
import clsx from 'clsx';
import Link from '@docusaurus/Link';
import useDocusaurusContext from '@docusaurus/useDocusaurusContext';
import Layout from '@theme/Layout';
import Translate, {translate} from '@docusaurus/Translate';
import styles from './index.module.css';

function HomepageHeader() {
  const {siteConfig} = useDocusaurusContext();
  return (
    <header className={clsx('hero hero--primary', styles.heroBanner)}>
      <div className="container">
        <h1 className="hero__title">
        <Translate
                  id="homePage.siteconfig.title"
                  description="Guides and tutorials">
                  My Documentation
                </Translate>
        </h1>
        <p className="hero__subtitle">
        <Translate
                  id="homePage.siteconfig.tagline"
                  description="CI &amp; CD at its best">
                  This is m-m-my mmm-mmy mmmmmy documentation!
                </Translate></p>
        <div className={styles.buttons}>


          <Link className="button button--secondary button--lg"
            to="/docs/intro">
                <Translate
                  id="homePage.goToDocumentation">
                  Start reading the doc now! 💻
                </Translate>
              </Link>
        </div>
      </div>
    </header>
  );
}

function Hello() {
  return (
      <div className={styles.aboutDiv}>
        <h2 className="text-3xl leading-9 font-extrabold md:text-4xl md:leading-10"
            align='center'>
          <Translate
            id="homePage.aboutSectionTitle">
              About this documentation
          </Translate>
        </h2>
        <div className={styles.textDiv}>
          <p>
          L’année 1866 fut marquée par un événement bizarre, un phénomène inexpliqué et inexplicable que personne n’a sans doute oublié. Sans parler des rumeurs qui agitaient les populations des ports et surexcitaient l’esprit public à l’intérieur des continents, les gens de mer furent particulièrement émus. Les négociants, armateurs, capitaines de navires, skippers et masters de l’Europe et de l’Amérique, officiers des marines militaires de tous pays, et, après eux, les gouvernements des divers États des deux continents, se préoccupèrent de ce fait au plus haut point.
          </p>
          <p>
          En effet, depuis quelque temps, plusieurs navires s’étaient rencontrés sur mer avec « une chose énorme, » un objet long, fusiforme, parfois phosphorescent, infiniment plus vaste et plus rapide qu’une baleine.
          </p>
          <p>
          Les faits relatifs à cette apparition, consignés aux divers livres de bord, s’accordaient assez exactement sur la structure de l’objet ou de l’être en question, la vitesse inouïe de ses mouvements, la puissance surprenante de sa locomotion, la vie particulière dont il semblait doué. Si c’était un cétacé, il surpassait en volume tous ceux que la science avait classés jusqu’alors. Ni Cuvier, ni Lacépède, ni M. Dumeril, ni M. de Quatrefages n’eussent admis l’existence d’un tel monstre — à moins de l’avoir vu, ce qui s’appelle vu de leurs propres yeux de savants.
          </p>
        </div>
      </div>
  );
}

export default function Home() {
  const {siteConfig} = useDocusaurusContext();
  return (
    <Layout
      title={`${siteConfig.title}`}
      description={`${siteConfig.title}`}>
      <HomepageHeader />
      <Hello/>
    </Layout>
  );
}
